package com.example.android.afif_updated_apps_1212017;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class fragmentActivity extends Activity {
    private Button replaceFragmentButton, addFragmentButton, removeFragment;
    private static int FRAGMENT_ONE_POSITION = 0, FRAGMENT_TWO_POSITION = 0;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        replaceFragmentButton = (Button) findViewById(R.id.buttonOne);
        addFragmentButton = (Button) findViewById(R.id.buttonTwo);
        removeFragment =(Button)findViewById(R.id.buttonThree);
        replaceFragmentButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentOneTransaction = getFragmentManager().beginTransaction();

                switch (FRAGMENT_ONE_POSITION) {
                    case 0:
                        FRAGMENT_ONE_POSITION++;
                        fragmentOneTransaction.replace(R.id.fragment_one_holder, new fragmentOne(fragmentActivity.this));
                        break;
                    case 1:
                        FRAGMENT_ONE_POSITION++;
                        fragmentOneTransaction.replace(R.id.fragment_one_holder, new fragmenTwo(fragmentActivity.this));

                        break;
                    case 2:
                        FRAGMENT_ONE_POSITION = 0;
                        fragmentOneTransaction.replace(R.id.fragment_one_holder, new fragmenThree(fragmentActivity.this));
                        break;
                    default:
                        break;
                }

                fragmentOneTransaction.addToBackStack(null);
                fragmentOneTransaction.commit();

            }
        });

        removeFragment.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTwoTransaction = getFragmentManager().beginTransaction();
                switch (FRAGMENT_TWO_POSITION) {
                    case 0:
                        FRAGMENT_TWO_POSITION++;
                        fragmentTwoTransaction.remove( new fragmenThree(fragmentActivity.this));
                        break;
                    case 1:
                        FRAGMENT_TWO_POSITION++;
                        fragmentTwoTransaction.remove( new fragmenTwo(fragmentActivity.this));
                        break;

                    case 2:
                        FRAGMENT_TWO_POSITION = 0;
                        fragmentTwoTransaction.remove( new fragmentOne(fragmentActivity.this));
                        break;

                    default:
                        break;
                }


                fragmentTwoTransaction.addToBackStack(null);
                fragmentTwoTransaction.commit();


            }
        });

        addFragmentButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTwoTransaction = getFragmentManager().beginTransaction();

                switch (FRAGMENT_TWO_POSITION) {
                    case 0:
                        FRAGMENT_TWO_POSITION++;
                        fragmentTwoTransaction.add(R.id.fragment_two_holder, new fragmentOne(fragmentActivity.this));
                        break;
                    case 1:
                        FRAGMENT_TWO_POSITION++;
                        fragmentTwoTransaction.add(R.id.fragment_two_holder, new fragmenTwo(fragmentActivity.this));
                        break;
                    case 2:
                        FRAGMENT_TWO_POSITION = 0;
                        fragmentTwoTransaction.add(R.id.fragment_two_holder, new fragmenThree(fragmentActivity.this));
                        break;
                    default:
                        break;
                }


                fragmentTwoTransaction.addToBackStack(null);
                fragmentTwoTransaction.commit();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public void onBackPressed() {
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
        } else {
            super.onBackPressed();
        }

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("fragment Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
