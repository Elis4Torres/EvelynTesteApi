/*
 * Copyright (C) 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.login;
        import android.net.Uri;
        import android.util.Log;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;
        import java.net.URLEncoder;

        import okhttp3.Headers;
        import okhttp3.MultipartBody;
        import okhttp3.OkHttpClient;
        import okhttp3.Request;
        import okhttp3.RequestBody;
        import okhttp3.Response;

public class NetworkUtils {
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();

    private static final String APIEVELYN_URL = "https://api.evelynhugo.org/";

    private static final OkHttpClient client = new OkHttpClient();

    // Mudar nome para BuscaDaApi
    static String buscaAutora(String autoraString) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String evelynQJSONString = null;
        try {
            // Construção da URI de Busca
            Uri builtURI = Uri.parse(APIEVELYN_URL).buildUpon()
                    .appendPath(URLEncoder.encode(autoraString, "UTF-8"))
                    .build();
            // Converte a URI para a URL.
            URL requestURL = new URL(builtURI.toString());
            // Abre a conexão de rede
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            // Busca o InputStream.
            InputStream inputStream = urlConnection.getInputStream();
            // Cria o buffer para o input stream
            reader = new BufferedReader(new InputStreamReader(inputStream));
            // Usa o StringBuilder para receber a resposta.
            StringBuilder builder = new StringBuilder();
            String linha;
            // Log.d(LOG_TAG, builtURI.toString()); // mostra a uri da api no log pra ver se tá tudo certo
            while ((linha = reader.readLine()) != null) {
                // Adiciona a linha a string.
                builder.append(linha);
                builder.append("\n");
            }
            if (builder.length() == 0) {
                // se o stream estiver vazio não faz nada
                return null;
            }
            evelynQJSONString = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // fecha a conexão e o buffer.
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // escreve o Json no log
        Log.d(LOG_TAG, evelynQJSONString);
        return evelynQJSONString;
    }

    static String buscaUsuarios(String usuarioString) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String filmeQJSONString = null;
        try {
            // Construção da URI de Busca
            Uri builtURI = Uri.parse(PANICOAPI_URL).buildUpon()
                    .appendPath(URLEncoder.encode(usuarioString, "UTF-8"))
                    .build();
            // Converte a URI para a URL.
            URL requestURL = new URL(builtURI.toString());
            // Abre a conexão de rede
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            // Busca o InputStream.
            InputStream inputStream = urlConnection.getInputStream();
            // Cria o buffer para o input stream
            reader = new BufferedReader(new InputStreamReader(inputStream));
            // Usa o StringBuilder para receber a resposta.
            StringBuilder builder = new StringBuilder();
            String linha;
            // Log.d(LOG_TAG, builtURI.toString()); // mostra a uri da api no log pra ver se tá tudo certo
            while ((linha = reader.readLine()) != null) {
                // Adiciona a linha a string.
                builder.append(linha);
                builder.append("\n");
            }
            if (builder.length() == 0) {
                // se o stream estiver vazio não faz nada
                return null;
            }
            filmeQJSONString = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // fecha a conexão e o buffer.
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // escreve o Json no log
        Log.d(LOG_TAG, filmeQJSONString);
        return filmeQJSONString;
    }

    static String buscaAtores(String atoresString) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String filmeQJSONString = null;
        try {
            // Construção da URI de Busca
            Uri builtURI = Uri.parse(PANICOAPI_URL).buildUpon()
                    .appendPath(URLEncoder.encode(atoresString, "UTF-8"))
                    .build();
            // Converte a URI para a URL.
            URL requestURL = new URL(builtURI.toString());
            // Abre a conexão de rede
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            // Busca o InputStream.
            InputStream inputStream = urlConnection.getInputStream();
            // Cria o buffer para o input stream
            reader = new BufferedReader(new InputStreamReader(inputStream));
            // Usa o StringBuilder para receber a resposta.
            StringBuilder builder = new StringBuilder();
            String linha;
            // Log.d(LOG_TAG, builtURI.toString()); // mostra a uri da api no log pra ver se tá tudo certo
            while ((linha = reader.readLine()) != null) {
                // Adiciona a linha a string.
                builder.append(linha);
                builder.append("\n");
            }
            if (builder.length() == 0) {
                // se o stream estiver vazio não faz nada
                return null;
            }
            filmeQJSONString = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // fecha a conexão e o buffer.
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // escreve o Json no log
        Log.d(LOG_TAG, filmeQJSONString);
        return filmeQJSONString;
    }

    static String buscaPersonagens(String personagensString) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String filmeQJSONString = null;
        try {
            // Construção da URI de Busca
            Uri builtURI = Uri.parse(PANICOAPI_URL).buildUpon()
                    .appendPath(URLEncoder.encode(personagensString, "UTF-8"))
                    .build();
            // Converte a URI para a URL.
            URL requestURL = new URL(builtURI.toString());
            // Abre a conexão de rede
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            // Busca o InputStream.
            InputStream inputStream = urlConnection.getInputStream();
            // Cria o buffer para o input stream
            reader = new BufferedReader(new InputStreamReader(inputStream));
            // Usa o StringBuilder para receber a resposta.
            StringBuilder builder = new StringBuilder();
            String linha;
            // Log.d(LOG_TAG, builtURI.toString()); // mostra a uri da api no log pra ver se tá tudo certo
            while ((linha = reader.readLine()) != null) {
                // Adiciona a linha a string.
                builder.append(linha);
                builder.append("\n");
            }
            if (builder.length() == 0) {
                // se o stream estiver vazio não faz nada
                return null;
            }
            filmeQJSONString = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // fecha a conexão e o buffer.
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // escreve o Json no log
        Log.d(LOG_TAG, filmeQJSONString);
        return filmeQJSONString;
    }

    static String buscaObraID(String obraString, String movieString) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String filmeQJSONString = null;
        try {
            // Construção da URI de Busca
            Uri builtURI = Uri.parse(PANICOAPI_URL).buildUpon()
                    .appendPath(URLEncoder.encode(obraString, "UTF-8"))
                    .appendPath(URLEncoder.encode(movieString, "UTF-8"))
                    .build();
            // Converte a URI para a URL.
            URL requestURL = new URL(builtURI.toString());
            // Abre a conexão de rede
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            // Busca o InputStream.
            InputStream inputStream = urlConnection.getInputStream();
            // Cria o buffer para o input stream
            reader = new BufferedReader(new InputStreamReader(inputStream));
            // Usa o StringBuilder para receber a resposta.
            StringBuilder builder = new StringBuilder();
            String linha;
            // Log.d(LOG_TAG, builtURI.toString()); // mostra a uri da api no log pra ver se tá tudo certo
            while ((linha = reader.readLine()) != null) {
                // Adiciona a linha a string.
                builder.append(linha);
                builder.append("\n");
            }
            if (builder.length() == 0) {
                // se o stream estiver vazio não faz nada
                return null;
            }
            filmeQJSONString = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // fecha a conexão e o buffer.
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // escreve o Json no log
        Log.d(LOG_TAG, filmeQJSONString);
        return filmeQJSONString;
    }

    @Deprecated
    static String cadastraUsuario(String nomeString, String senhaString) {
        try {
            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("nome", nomeString)
                    .addFormDataPart("senha", senhaString)
                    .build();

            Request request = new Request.Builder()
                    .url("http://myip/task_manager/v1/register")
                    .post(requestBody)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Headers responseHeaders = response.headers();
                for (int i = 0; i < responseHeaders.size(); i++) {
                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                }

                System.out.println(response.body().string());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return nomeString;
    }
}