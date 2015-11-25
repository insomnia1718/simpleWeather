package com.example.insomnia.weather.main;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.insomnia.weather.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ChatActivity extends BaseActivity {

    @Bind(R.id.chat_input_text)
    EditText chatInputText;
    @Bind(R.id.chat_send_bn)
    Button chatSendBn;
    @Bind(R.id.chat_content)
    ListView chatContent;
    private View robotMessage;
    private View userMessage;
    private TextView userMsgContent;
    private TextView robotMsgContent;
    private ArrayList<HashMap<String,String>> msgData;
    ChatAdapter adapter;
    private static final String CHATKEY = "a3bde6054c4308368c46b8094d77e858";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);
        msgData = new ArrayList<>();
        setClick();
        setChatContentAdapter();
    }

    public void setClick() {
        chatSendBn.setOnClickListener(view -> {
            String userContent = chatInputText.getText().toString();
            String utf8content = "";
            try {
                utf8content = URLEncoder.encode(userContent,"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            chatInputText.setText("");
            HashMap<String,String> m = new HashMap<>();
            m.put("user", userContent);
            msgData.add(m);
            adapter.notifyDataSetChanged();
            String request = "http://www.tuling123.com/openapi/api?key="+CHATKEY+"&info="+utf8content;
            Log.i("usercontent", request);
            new ChatTask().execute(request);
        });

    }

    private class ChatTask extends AsyncTask<String,Integer,JSONObject>{

        @Override
        protected JSONObject doInBackground(String[] params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setDoInput(true);
                conn.setReadTimeout(3000);
                conn.setConnectTimeout(3000);
                conn.connect();
                InputStream is = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                StringBuilder builder = new StringBuilder();
                String temp = "";
                while((temp = reader.readLine())!=null){
                    builder.append(temp);
                }
                String result = builder.toString();
                return new JSONObject(result);
            } catch (Exception e) {
                e.printStackTrace();

            }

            return null;
        }

        @Override
        protected void onPostExecute(JSONObject o) {
            super.onPostExecute(o);
            if (o!=null) {
                String msg = "";
                try {
                    msg = (String) o.get("text");
                    msg = msg.replaceAll("<br>","\n");
                    if (o.has("url")){
                        if (!TextUtils.isEmpty((String)o.get("url")))
                        msg = msg+"\n"+o.get("url");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (!TextUtils.isEmpty(msg)) {
                    HashMap<String, String> m = new HashMap<>();

                    m.put("robot", msg);
                    msgData.add(m);
                    adapter.notifyDataSetChanged();
                }
            }else{
                HashMap<String, String> m = new HashMap<>();
                m.put("robot", "已死，有事烧纸。");
                msgData.add(m);
                adapter.notifyDataSetChanged();
            }
        }
    }

    private class ChatAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            Log.i("count",String.valueOf(msgData.size()));
            return msgData.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public boolean isEnabled(int position) {
            return false;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (msgData.get(position).containsKey("user")) {
                convertView = getLayoutInflater().inflate(R.layout.message_user, null);
                userMsgContent = (TextView) convertView.findViewById(R.id.message_text_user);
                userMsgContent.setText(msgData.get(position).get("user"));
            }else{
                convertView = getLayoutInflater().inflate(R.layout.message_robot, null);
                userMsgContent = (TextView) convertView.findViewById(R.id.message_text_robot);
                userMsgContent.setText(msgData.get(position).get("robot"));
            }
            return convertView;
        }
    }

    private void setChatContentAdapter(){
        adapter = new ChatAdapter();
        chatContent.setAdapter(adapter);
    }
}
