package lt.andro.smsbomber;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            final View buttonSend = rootView.findViewById(R.id.buttonSend);
            buttonSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final TextView phoneNumberView = (TextView) rootView.findViewById(R.id.editTextPhoneNumber);
                    final TextView countView = (TextView) rootView.findViewById(R.id.editTextCount);
                    final TextView messageView = (TextView) rootView.findViewById(R.id.editTextMessage);

                    final String phoneNumber = phoneNumberView.getText().toString();
                    final int count = Integer.parseInt(countView.getText().toString());
                    final String message = messageView.getText().toString();

                    final SmsManager smsManager = SmsManager.getDefault();
                    for (int i = 0; i < count; i++) {
                        smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                    }
                }
            });
            return rootView;
        }
    }

}
