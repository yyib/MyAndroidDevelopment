package com.example.daddy.myapplication;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends ActionBarActivity
        implements View.OnClickListener,
        AdapterView.OnItemClickListener {

    Button timesTableButton;
    Button numberBondsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
     /*   getSupportActionBar().setLogo(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher);

*/

        //todo: refactor new namespaces etc
        //todo: git/repo/azure
        //todo: house colours
        //todo: some design work/mock ups
        //todo: welcome splash screen
        //todo: authentication, per user
        //todo: sub-screens for if chosen times tables
        //todo: sign-up to google developer so can publish to app store.
        String User = GetUserName();

        DisplayTextInView(R.id.main_textview,"Welcome Back");
        ShowToastWelcome(User);

        ShowWelcomeNotification("Player Signed In","Welcome to "+ getString(R.string.app_name) + " " + User);


//        Spinner spinner = (Spinner) findViewById(R.id.timesTableSpinner);
//// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.timesTables_array, android.R.layout.simple_spinner_item);
//// Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//// Apply the adapter to the spinner
//        spinner.setAdapter(adapter);



        timesTableButton = (Button) findViewById(R.id.button_timesTables);
        timesTableButton.setOnClickListener(this);


        numberBondsButton = (Button) findViewById(R.id.button_numberBonds);
        numberBondsButton.setOnClickListener(this);


    }

    public void DisplayTextInView(int view, String text)
    {
        // 1. Access the TextView defined in layout XML
        // and then set its text
        TextView mainTextView = (TextView) findViewById(view);
        mainTextView.setText(text);
        //
    }

    protected String GetUserName()
    {
        return "Paul";
    }

    public void ShowToastWelcome(String userName)
    {
        Context context = getApplicationContext();

        CharSequence text = userName.isEmpty() ? "Welcome - Let's get started !!!" :
                "Welcome " + userName + " - Let's get started !!!";

        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        toast.show();
    }

    public void ShowWelcomeNotification(String title, String message)
    {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle(title)
                        .setContentText(message);
        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, HomeActivity.class);

        // The stack builder object will contain an artificial back stack for the
        // started Activity.
        // This ensures that navigating backward from the Activity leads out of
        // your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(HomeActivity.class);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // mId allows you to update the notification later on.
        int mId =0;
        mNotificationManager.notify(mId, mBuilder.build());

        //permit user to swipe/cancel away the notification in the notification bar
        mBuilder.setAutoCancel(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if (v.equals(timesTableButton)) {

            Log.v("ThisApp", "onClick Successful - timesTableButton");


            Intent intent = new Intent(this,TimestablesActivity.class);
            this.startActivity(intent);
        }

        if (v.equals(numberBondsButton)) {

            Log.v("ThisApp", "onClick Successful - numberBondsButton");


            Intent intent = new Intent(this,NumberBondsActivity.class);
            this.startActivity(intent);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
