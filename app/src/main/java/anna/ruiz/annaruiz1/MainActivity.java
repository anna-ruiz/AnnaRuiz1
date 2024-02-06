package anna.ruiz.annaruiz1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import anna.ruiz.annaruiz1.Adapters.memeAdapter;
import anna.ruiz.annaruiz1.Conexiones.ApiConexiones;
import anna.ruiz.annaruiz1.Conexiones.RetrofitObject;
import anna.ruiz.annaruiz1.Configuraciones.configuracion;
import anna.ruiz.annaruiz1.Modelos.Data;
import anna.ruiz.annaruiz1.Modelos.MemesItem;
import anna.ruiz.annaruiz1.Modelos.Respuesta;
import anna.ruiz.annaruiz1.databinding.ActivityMainBinding;
import anna.ruiz.annaruiz1.helpers.MemeHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    
    private memeAdapter adapter;
    private RecyclerView.LayoutManager lm;
    private ArrayList<MemesItem> listaMemes;
    private ArrayList<MemesItem> listaMemesLocal;
    private ActivityMainBinding binding;

    private MemeHelper helper;
    private Dao<MemesItem, String> daoMemes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        //inicializar lista
        listaMemes = new ArrayList<>();
        
        adapter = new memeAdapter(this, R.layout.meme_view_holder, listaMemes);
        lm = new LinearLayoutManager(this);

        binding.contenedor.setAdapter(adapter);
        binding.contenedor.setLayoutManager(lm);

        traerInfoApi();

/*

        helper = new MemeHelper(this, configuracion.BD_NOMBRE, null, configuracion.BD_VERSION);
        if (helper != null){
            try {
                daoMemes = helper.getDaoMemes();
                listaMemesLocal.addAll(daoMemes.queryForAll());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
*/



    }

    private void traerInfoApi() {
        Retrofit retrofit = RetrofitObject.getConexion();
        ApiConexiones api = retrofit.create(ApiConexiones.class);
        Call<Respuesta> getMemes = api.getMemes();
        
        getMemes.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                if (response.code() == HttpsURLConnection.HTTP_OK){
                    Respuesta temp = response.body(); //cogemos el array de la respuesta de la api

                    //listaMemes.addAll(temp);
                    //adapter.notifyItemRangeInserted(0, temp.size());

                    Log.e("FAILURE", temp.toString()); //comprobar q recoge los datos

                    listaMemes.addAll(temp.getData().getMemes());
                    adapter.notifyItemRangeInserted(0, temp.getData().getMemes().size());

                }else {
                    Toast.makeText(MainActivity.this,response.message(), Toast.LENGTH_SHORT).show();
                }
                
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: te falta interneteee", Toast.LENGTH_SHORT).show();
                Log.e("FAILURE", t.getLocalizedMessage());
            }
        });
    }
}