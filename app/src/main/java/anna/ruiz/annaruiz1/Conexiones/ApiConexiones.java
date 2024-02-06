package anna.ruiz.annaruiz1.Conexiones;

import java.lang.reflect.Array;
import java.util.ArrayList;

import anna.ruiz.annaruiz1.Modelos.MemesItem;
import anna.ruiz.annaruiz1.Modelos.Respuesta;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiConexiones {
    @GET("get_memes")
    Call<Respuesta> getMemes();
}
