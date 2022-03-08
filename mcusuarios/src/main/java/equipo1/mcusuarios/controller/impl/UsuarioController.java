package equipo1.mcusuarios.controller.impl;

import equipo1.mcusuarios.controller.UsuarioAPI;
import equipo1.mcusuarios.model.UsuarioDTO;
import equipo1.mcusuarios.service.UsuarioService;
import equipo1.mcusuarios.util.AES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("usuarios")
public class UsuarioController implements UsuarioAPI {

    @Autowired
    UsuarioService usuarioService;

    @Override
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        return usuarioService.getAll();
    }

    @Override
    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuariodto) {
        return usuarioService.create(usuariodto);
    }

    @Override
    @PostMapping("/login")
    public boolean login(String userName, String clave) {
        return usuarioService.login(userName, clave);
    }

    @Override
    @GetMapping("/{dni}")
    public ResponseEntity<UsuarioDTO> get(@PathVariable String dni) {
        return usuarioService.get(dni);
    }

    @Override
    @PutMapping("/{dni}")
    public ResponseEntity<UsuarioDTO> modify(@PathVariable String dni, @RequestBody UsuarioDTO usuariodto) {
        return usuarioService.modify(dni,usuariodto);
    }
    @Override
    @DeleteMapping("/{dni}")
    public ResponseEntity<String> delete(@PathVariable String dni) {
        return usuarioService.delete(dni);
    }

    @Override
    @PostMapping("/log")
    public boolean logUser(@RequestBody Object string) {
        File file = new File("miLog.txt");
        final String secretKey = "miClaveSecreta";
        String stringRecibido = string.toString();
        String textoEncriptado = AES.encrypt(stringRecibido, secretKey) ;

            if (!file.exists()) {
                try{
                    file.createNewFile();
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(textoEncriptado);
                    bw.close();
                }catch (Exception e){

                }
            }else{
                try{
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    Iterator it = br.lines().collect(Collectors.toList()).iterator();
                    br.close();
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    while(it.hasNext()){
                        bw.write(it.next().toString());
                        bw.newLine();
                    }
                    bw.write(textoEncriptado);
                    bw.close();


                }catch (Exception e){

                }
            }

        System.out.println("Desencriptado: "+AES.decrypt(textoEncriptado, secretKey));
        return true;
    }
}


