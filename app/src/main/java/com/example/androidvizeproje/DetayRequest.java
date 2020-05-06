package com.example.androidvizeproje;

import android.os.Bundle;

public class DetayRequest extends TemelRequest {

    public RequestListener listener;

    @Override
    public String getReqUrl() {

        return "https://coronavirus-monitor.p.rapidapi.com/coronavirus/cases_by_country.php?rapidapi-key=577e1f28d2msh8b2bf1fed9ebd7ep1df55fjsn5b55f896a62a";
    }

    public interface RequestListener {

        public void RequesDone(String result);
    }


    public DetayRequest(RequestListener listener){

        this.listener = listener;

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.RequesDone(result);
    }

}
