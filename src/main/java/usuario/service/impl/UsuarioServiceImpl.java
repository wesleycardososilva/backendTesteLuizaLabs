package usuario.service.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import usuario.dto.UsuarioDTO;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

public class UsuarioServiceImpl {

   public UsuarioDTO getSenhaPorUsuario (String usuario) throws IOException {
       OkHttpClient client = new OkHttpClient().newBuilder()
               .connectTimeout(30, TimeUnit.SECONDS)
               .writeTimeout(30, TimeUnit.SECONDS)
               .readTimeout(30, TimeUnit.SECONDS)
               .build();
       Request request = new Request.Builder()
               .url("http://localhost:8082/pje/service/usuario?nomeDoUsuario="+URLEncoder.encode(usuario))
               .method("GET", null)
               .addHeader("Authorization", "Bearer null")
               .build();
       Response response = client.newCall(request).execute();
       String teste = response.body().string();
       JsonParser parser = new JsonParser();
       JsonObject o = parser.parse(teste).getAsJsonObject();
       UsuarioDTO UsuarioDTO = new UsuarioDTO();
       JsonToUsuarioDTO(o, UsuarioDTO);
       return UsuarioDTO;
   }

   public UsuarioDTO JsonToUsuarioDTO(JsonObject json, UsuarioDTO UsuarioDTO){

       UsuarioDTO.setId(json.get("id").getAsLong());
       UsuarioDTO.setNomeDoUsuario(json.get("nomeDoUsuario").getAsString());
       UsuarioDTO.setSenhaDoUsuario(json.get("senhaDoUsuario").getAsString());
       UsuarioDTO.setUuid(json.get("uuid").getAsString());
       return UsuarioDTO;
   }
}
