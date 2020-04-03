package com.example.androidvizeproje;

public class EtkilenenUlkeReq extends TemelRequest {

    public EtkUlkeReqListener listener;

    @Override
    public String getReqUrl() {
        return "https://coronavirus-monitor.p.rapidapi.com/coronavirus/affected.php?rapidapi-key=577e1f28d2msh8b2bf1fed9ebd7ep1df55fjsn5b55f896a62a";
    }

    public interface EtkUlkeReqListener{
        public void  onRequestDone(String result);
    }

    public EtkilenenUlkeReq(EtkUlkeReqListener listener){
        this.listener = listener;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.onRequestDone(result);

    }
}
