package com.example.androidvizeproje;

public class DetayReq extends TemelRequest {

    DetayReqListener listener;


    public interface DetayReqListener{
        void onRequestDone(String result);
    }


    public DetayReq(DetayReqListener listener){ // oluþtuurulduðu method

        this.listener = listener ;
    }

    String result = "";

    @Override
    public String getReqUrl() {
        return "https://coronavirus-monitor.p.rapidapi.com/coronavirus/cases_by_country.php?rapidapi-key=577e1f28d2msh8b2bf1fed9ebd7ep1df55fjsn5b55f896a62a";
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.onRequestDone(result);
    }
}
