package com.example.androidvizeproje;

public class Request extends TemelRequest {

    public ReqListener listener;

    @Override
    public String getReqUrl() {
        return "https://coronavirus-monitor.p.rapidapi.com/coronavirus/worldstat.php?rapidapi-key=577e1f28d2msh8b2bf1fed9ebd7ep1df55fjsn5b55f896a62a";
    }

    public interface ReqListener {
        public void ReqDone(String result);
    }

    public Request(ReqListener listener){
        this.listener = listener;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.ReqDone(result);
    }
}
