package npi.ufc.com.coberturacelular.service;

import android.app.Application;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import npi.ufc.com.coberturacelular.model.DadosMoveis;
import npi.ufc.com.coberturacelular.model.LocalizacaoGeografica;


public class RequisicaoDadosService extends Application{

    /**
     *
     * Método que faz a requisição POST e envia o JSON dos dados coletados para o servidor rest da
     * sequinte url:http://rest.learncode.academy/api/cobertura-celular/dados
     *
     */

    public void requisicaoPostServidor(DadosMoveis dadosMoveis){

        RequestQueue request = Volley.newRequestQueue(this);
        String url = "http://rest.learncode.academy/api/cobertura-celular/dados";
        Gson gson = new Gson();
        final String jsonServidor = gson.toJson(dadosMoveis);

        StringRequest MinhaRequisicao = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //This code is executed if the server responds, whether or not the response contains data.
                //The String 'response' contains the server's response.
            }
        }, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
            @Override
            public void onErrorResponse(VolleyError error) {
                //Este código é executado se tiver error.
            }
        }) {

            //Adicione aqui os dados que você quer mandar pro servidor.
            protected Map<String, String> getParams() {
                Map<String, String> meusDados = new HashMap<String, String>();
                meusDados.put("Dados", jsonServidor);
                return meusDados;
            }
        };

        request.add(MinhaRequisicao);
    }



}


