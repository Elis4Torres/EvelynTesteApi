package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AutoraActivity extends AppCompatActivity {
    private TextView nomeTextView;

    private TextView livrosTextView;
    private TextView biografiaTextView;
    private TextView premiosTextView;
    private ImageView textureUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autora);


        nomeTextView = findViewById(R.id.nomeTextView);
        livrosTextView = findViewById(R.id.livrosTextView);
        biografiaTextView = findViewById(R.id.biografiaTextView);
        premiosTextView = findViewById(R.id.premiosTextView);

        String APIUrl = "https://evelyn-17f2.onrender.com/evelyn/getEvelyn?name=earth";
        FetchAutoraDateTask task = new FetchAutoraDateTask();
        task.execute(APIUrl);
    }

    private class FetchAutoraDateTask extends AsyncTask<String, Void, AutoraDate> {

        @Override
        protected AutoraDate doInBackground(String... urls) {
            String planetUrl = urls[0];
            String jsonResponse = "";

            try {
                URL url = new URL(planetUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    jsonResponse += line;
                }

                bufferedReader.close();
                inputStream.close();
                connection.disconnect();

                JSONObject jsonObject = new JSONObject(jsonResponse);

                String nome = jsonObject.optString("nome", "");
                String livros = jsonObject.optString("livros", "");
                String biografia = jsonObject.optString("biografia", "");
                String premios = jsonObject.optString("premios", "");

                return new AutoraDate(nome, livros, biografia, premios);
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(AutoraDate AutoraDate) {
            if (AutoraDate != null) {
                nomeTextView.setText(AutoraDate.getNome());
                livrosTextView.setText(AutoraDate.getLivros());
                Glide.with(AutoraActivity.this)
                        .load(AutoraDate.getLivros())
                        .circleCrop()
                        .into(textureUrl);

                // Configurar os campos extras
                Glide.with(AutoraActivity.this)
                        .load(AutoraDate.getBiografia())
                        .into(textureUrl);

                Glide.with(AutoraActivity.this)
                        .load(AutoraDate.getPremios())
                        .into(textureUrl);
            }
        }
    }
}
