package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button logIn = findViewById(R.id.logIn_Button);
        logIn.setOnClickListener(v -> {
            startActivity(new Intent(this,MainActivity.class));
        });
    }
}
