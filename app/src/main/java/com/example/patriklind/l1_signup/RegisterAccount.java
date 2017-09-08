package com.example.patriklind.l1_signup;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**Evaluates the inputs in the UI and attempts to register a new account in the system.
     *
     * @param view : View
     */
    public void registerAccount(View view){

       String password =((EditText)findViewById(R.id.etPassword)).getText().toString();
       String email = ((EditText)findViewById(R.id.etEmail)).getText().toString();
       String result = "Registration complete";
       String title ="Success";

        if(!checkEmail(email)|| !checkPassword(password)){
            result="";
            if(!checkEmail(email)){
                result+="Invalid email\n";
                title ="Error";
            }
            if(!checkPassword(password)){
                result+="Password is too short\n";
                title = "Error";
            }
        }

        showDialog(title, result);

    }

    /**Validates the password to match the password requirements. For now the only requirement is
     * lenght>=6
     *
     * @param password : String
     * @return : boolean
     */
    private boolean checkPassword(String password) {
        //TODO add additional requirements, ie uppercase letters, symbols, check passwordRepeat!
        if(password.length()<6){
            return false;
        }else{
            return true;
        }
    }

    /**Validates the email to see if input meets the email requirements. Doesn't check if the email
     * is already registered in the system, YET!
     *
     * @param email : String
     * @return : boolean
     */
    private boolean checkEmail(String email) {
        //TODO: check if email is already registered in DB
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**Shows a simple AlertDialog with title and message passed in as argument.
     *
     * @param title : String
     * @param message : String
     */
    private void showDialog(String title, String message){
        AlertDialog dialog = new AlertDialog.Builder(RegisterAccount.this).create();
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Ok", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
