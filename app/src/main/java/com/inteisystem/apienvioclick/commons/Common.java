package com.inteisystem.apienvioclick.commons;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.inteisystem.apienvioclick.BuildConfig;
import com.inteisystem.apienvioclick.R;
public class Common {

    private Context mContext;
    static ProgressDialog progressDialog;
    public Common(Context context){
        mContext = context;
    }

    public boolean isValidEmail(String edt){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        return edt.trim().matches(emailPattern);
    }

    public String validNull(String data){
        return data != null ? data : mContext.getString(R.string.No_Disponible);
    }

    // TODO guardar en pref local
    public void saveApiKey(String apiKey){
    /*    SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(constants.TAG_USER_KEY, apiKey).apply();
        editor.commit(); */
    }

    public boolean validSpaces(EditText editText){
        String idKey = editText.getText().toString().trim();
        return !idKey.equals("");
    }

    public void shareThisApp(){
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, mContext.getString(R.string.app_name));
            String shareMessage= "\nTe recomiendo esta aplicación\n\n";
            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            mContext.startActivity(Intent.createChooser(shareIntent, "Elije a quien compartir!"));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void Logger(String log, Boolean isToast){
        if (BuildConfig.DEBUG){
            if (!isToast){
                Log.d("Logger: ",log);
            }else{
                Toast.makeText(mContext, log, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static ProgressDialog showLoading(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

    public static void hideLoading() {
        if (progressDialog == null) {
            return;
        }
        progressDialog.dismiss();
    }

    public void goToNextActivity(Class view){
        if (view != null){
            Intent i = new Intent(mContext, view);
            mContext.startActivity(i);
        }/*else{ TODO definir modal para esta parte
            ComingSoonActivity comingSoon = new ComingSoonActivity(mContext);
            comingSoon.show(((AppCompatActivity) mContext).getSupportFragmentManager(),comingSoon.getTag());
        }*/
    }


}
