package com.example.bam.tracker;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class MyAsync extends AsyncTask<ArrayList<String>,Void,String> {
   private Dialog load;
    String user,pass,email,no;
    int flag;
    Context me;
    public MyAsync(Context context)
    {
        me=context;

    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    load=ProgressDialog.show(me,"Authentication Process","Loading Plz Wait...");
        load.show();


    }

    @Override
    protected void onPostExecute(String s) {
        load.dismiss();
        super.onPostExecute(s);
        Toast.makeText(me,""+s,Toast.LENGTH_LONG).show();
        me.startActivity(new Intent(me, User.class));


    }

    @Override
    protected String doInBackground(ArrayList<String>... val) {
        ArrayList<String> am=val[0];
        user=am.get(0);
        pass=am.get(1);
        email=am.get(2);
        no=am.get(3);
        flag= Integer.parseInt(am.get(4));



        switch (flag)
        {

            case 0:
            {
                try {
                    return register(user,pass,email,no);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 1: {
                try {
                    return login(no, pass);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }

        }

        return null;
    }
    public String register(String username,String password,String email,String no) throws IOException {
        String dat="";
        String urlParameters  = "username="+username+"&password="+password+"&phoneno="+no+"&emailid="+email;
        byte[] postData  ;
        postData = urlParameters.getBytes( );
        int    postDataLength = postData.length;
        String request        = "http://bam.16mb.com/simple.php";
        URL    url            = new URL( request);
        HttpURLConnection conn= (HttpURLConnection) url.openConnection();

        conn.setDoOutput( true );
        conn.setInstanceFollowRedirects( false );
        conn.setRequestMethod( "POST" );
        conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty( "charset", "utf-8");
        conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
        conn.setUseCaches( false );
        try {
            DataOutputStream wr = new DataOutputStream( conn.getOutputStream());
            wr.write( postData );
            wr.flush();
            InputStream in=conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line=br.readLine();
            while(line!=null)
            {
               dat+=line;
                line=br.readLine();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return dat;

    }
    public String login(String phoneNumber,String passcode) throws IOException {

       String sdata="";
        String urlParameters  = "phoneno="+phoneNumber+"&password="+passcode;
        byte[] postData       = urlParameters.getBytes();
        int    postDataLength = postData.length;
        String request        = "http://bam.16mb.com/loginacc.php";
        URL    url            = new URL(  request);
        HttpURLConnection conn= (HttpURLConnection) url.openConnection();

        conn.setDoOutput( true );
        conn.setInstanceFollowRedirects( false );
        conn.setRequestMethod( "POST" );
        conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty( "charset", "utf-8");
        conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
        conn.setUseCaches( false );
        try
        {
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.write( postData );
            wr.flush();
            InputStream in=conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line=br.readLine();
            while(line!=null)
            {
                sdata+=line;
                line=br.readLine();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
return sdata;
    }
}
