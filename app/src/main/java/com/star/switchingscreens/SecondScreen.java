package com.star.switchingscreens;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondScreen extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        Intent activityThatCalled = getIntent();

//        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");

        Human bob = (Human) activityThatCalled.getExtras().getSerializable("humanBob");

        TextView callingActivityMessage = (TextView)
                findViewById(R.id.calling_activity_info_text_view);

        callingActivityMessage.setText(bob.getName() + " " + bob.getHeight() + " ft " +
                bob.getWeight() + " lbs");
    }

    public void onSendUsersName(View view) {

        EditText usersNameEditText = (EditText) findViewById(R.id.users_name_edit_text);

        String usersName = usersNameEditText.getText().toString();

        Intent goingBack = new Intent();

        goingBack.putExtra("UsersName", usersName);

        setResult(RESULT_OK, goingBack);

        finish();
    }
}
