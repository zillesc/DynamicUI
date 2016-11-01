package ninja.zilles.dynamicui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import static android.R.attr.x;
import static android.R.id.message;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private LinearLayout buttonLand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        buttonLand = (LinearLayout) findViewById(R.id.buttonLand);
//        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    public void onButtonClick(View view) {
        String newText = editText.getText().toString();
        Button newButton = new Button(this);
        newButton.setText(newText);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        newButton.setLayoutParams(params);
        buttonLand.addView(newButton);

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBookmarkClick(v);
            }
        });

        editText.setText("");
    }

//    public void onBookmarkClick(View view) {
//        String label = ((Button)view).getText().toString();
//
//        // Create a Uri from an intent string. Use the result to create an Intent.
////        Uri gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988");
//        Uri gmmIntentUri = Uri.parse("geo:40.1213578,-88.2169016?q=" + label);
//
//        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
//        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//        // Make the Intent explicit by setting the Google Maps package
//        mapIntent.setPackage("com.google.android.apps.maps");
//
//        // Attempt to start an activity that can handle the Intent
//        startActivity(mapIntent);
//    }

    public void onBookmarkClick(View view) {
        String label = ((Button)view).getText().toString();

        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse("sms:"));

        sendIntent.putExtra("sms_body", label);

        startActivity(sendIntent);
    }
}
