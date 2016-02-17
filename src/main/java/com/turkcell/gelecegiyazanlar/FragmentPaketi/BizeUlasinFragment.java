package com.turkcell.gelecegiyazanlar.FragmentPaketi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.util.Properties;


import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.turkcell.gelecegiyazanlar.ActivityPaketi.ProfilActivity;
import com.turkcell.gelecegiyazanlar.ActivityPaketi.YorumActivity;
import com.turkcell.gelecegiyazanlar.R;


public class BizeUlasinFragment extends android.support.v4.app.Fragment implements View.OnClickListener {
    private static final String username = "emailiniz";

    private static final String password = "þifreniz";

    private EditText emailEdit;

    private EditText subjectEdit;

    private EditText messageEdit;

    private EditText nameEdit;

    String email ;

    String gonderenemail;

    String name;

    String subject;

    String message;


    FloatingActionButton facebook,twitter,youtube;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootView= inflater.inflate(R.layout.fragment_bize_ulasin, container, false);

        emailEdit = (EditText) rootView.findViewById(R.id.editText_eposta);
        subjectEdit = (EditText)rootView.findViewById(R.id.editText_konu);
        messageEdit = (EditText) rootView.findViewById(R.id.editText_ileti);
        nameEdit= (EditText) rootView.findViewById(R.id.editText_isim);

        Button sendButton = (Button) rootView.findViewById(R.id.button_gonder);

        final FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.frame);
      // frameLayout.getBackground().setAlpha(0);
        final FloatingActionsMenu fabMenu = (FloatingActionsMenu) rootView.findViewById(R.id.fab_menu);
        facebook=(FloatingActionButton)rootView.findViewById(R.id.fab_face);
        twitter=(FloatingActionButton)rootView.findViewById(R.id.fab_twitter);
        youtube=(FloatingActionButton)rootView.findViewById(R.id.fab_youtube);

        facebook.setOnClickListener(this);
        twitter.setOnClickListener(this);
        youtube.setOnClickListener(this);

        fabMenu.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {

            @Override
            public void onMenuExpanded() {
          //   frameLayout.getBackground().setAlpha(240);
                frameLayout.setEnabled(false);
                frameLayout.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        fabMenu.collapse();
                        return true;
                    }
                });
            }

            @Override
            public void onMenuCollapsed() {

            //  frameLayout.getBackground().setAlpha(0);
                frameLayout.setOnTouchListener(null);
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email ="gelecegiyazanlar@gmail.com";
                gonderenemail=emailEdit.getText().toString();
                name=nameEdit.getText().toString();
                subject = subjectEdit.getText().toString();
                message = messageEdit.getText().toString();
                if(gonderenemail.isEmpty() ||name.isEmpty()||subject.isEmpty()||message.isEmpty() ){
                    Toast.makeText(getActivity(),"Tüm alanlarý doldurunuz!", Toast.LENGTH_SHORT).show();
                }else if(isNetworkAvailable()==false){
                    Toast.makeText(getActivity(),"Bir hata oluþtu! Tekrar deneyin..",Toast.LENGTH_SHORT).show();
                }
                else {
                    message = message +"\n\n\n" +"Gönderen e-mail: " + gonderenemail +"\n" + " Gönderen kiþi:" + name;
                    sendMail(email, subject, message);

                    nameEdit.setText("");
                    emailEdit.setText("");
                    subjectEdit.setText("");
                    messageEdit.setText("");



                }
            }
        });

        return rootView;
    }

    private void sendMail(String email, String subject, String messageBody) {
        Session session = createSessionObject();

        try {
            javax.mail.Message message = createMessage(email, subject, messageBody, session);
            new SendMailTask().execute(message);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private javax.mail.Message createMessage(String email, String subject, String messageBody, Session session) throws MessagingException, UnsupportedEncodingException {
        javax.mail.Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("gelecegiyazanlariletisim@gmail.com", name));
        message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(email, email));
        message.setSubject(subject);
        message.setText(messageBody);
        return message;
    }

    private Session createSessionObject() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        return Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    @Override
    public void onClick(View v) {
              switch (v.getId()){
                  case R.id.fab_face:
                      openBrowser("https://www.facebook.com/TurkcellGelecegiYazanlar");
                      break;
                  case R.id.fab_twitter:
                      openBrowser("https://twitter.com/GelecegiYazanlr");
                      break;
                  case R.id.fab_youtube:
                      openBrowser("https://www.youtube.com/channel/UCt03q1RpC8Jrifo88diQXnA");
                      break;
              }
    }

    public void openBrowser(String url){
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private class SendMailTask extends AsyncTask<javax.mail.Message, Void, Void> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(getActivity(), "Lütfen bekleyiniz", "Mail gönderiliyor...", true, false);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getActivity(), "Mailiniz baþarýyla gönderilmiþir...", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();

        }

        @Override
        protected Void doInBackground(javax.mail.Message... messages) {
            try {
                Transport.send(messages[0]);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public boolean isNetworkAvailable()

    {

        boolean connected = false;

        ConnectivityManager connectivityManager =

                (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState()

                == NetworkInfo.State.CONNECTED ||

                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState()

                        == NetworkInfo.State.CONNECTED) {

            //we are connected to a network

            connected = true;

        }

        else

            connected = false;

        return connected;

    }


}
