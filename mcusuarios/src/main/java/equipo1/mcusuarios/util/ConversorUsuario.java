package equipo1.mcusuarios.util;

import equipo1.mcusuarios.model.UsuarioDTO;
import equipo1.mcusuarios.model.UsuarioVO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ConversorUsuario {
    public static UsuarioDTO convertVOtoDTO(UsuarioVO usuariovo){
        UsuarioDTO usuariodto = new UsuarioDTO();
        usuariodto.setDNI(usuariovo.getDNI());
        usuariodto.setNombre(usuariovo.getNombre());
        usuariodto.setApellidos(usuariovo.getApellidos());
        usuariodto.setUsername(usuariovo.getUsername());
        usuariodto.setCorreo(usuariovo.getCorreo());
        usuariodto.setClave(usuariovo.getClave());
        usuariodto.setListaComentarios(usuariovo.getListaComentarios());
        usuariodto.setListaLibrosLeidos(usuariovo.getListaLibrosLeidos());
        return usuariodto;
    }

    public static UsuarioVO convertDTOtoVO(UsuarioDTO usuariodto){
        UsuarioVO usuariovo = new UsuarioVO();
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String clave = usuariodto.getClave();
            byte dataBytes[] = clave.getBytes();
            md.update(dataBytes);
            byte resumen[] = md.digest();
            usuariovo.setDNI(usuariodto.getDNI());
            usuariovo.setNombre(usuariodto.getNombre());
            usuariovo.setApellidos(usuariodto.getApellidos());
            usuariovo.setUsername(usuariodto.getUsername());
            usuariovo.setCorreo(usuariodto.getCorreo());
            usuariovo.setClave(new String (Hexadecimal(resumen)));
            usuariovo.setListaComentarios(usuariodto.getListaComentarios());
            usuariovo.setListaLibrosLeidos(usuariodto.getListaLibrosLeidos());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        return usuariovo;
    }

    static String Hexadecimal(byte[] resumen){
        String hex = "";
        for(int i = 0; i< resumen.length; i++){
            String h = Integer.toHexString(resumen[i] & 0xFF);
            if(h.length() == 1) hex += "0";
            hex+=h;
        }
        return hex;
    }
}
