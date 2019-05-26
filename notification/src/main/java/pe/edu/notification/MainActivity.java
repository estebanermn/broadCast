package pe.edu.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.IntentFilter;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final String BROADCAST_ACTION = "pe.edu.cibertect.broadcast.ACTION";

    public static final String NOTIFICATION_CHANNEL = "pe.edu.notification.CHANNEL";

    public static final String AIRPLANE_MODE = "android.intent.action.AIRPLANE_MODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register();

        crearNotificationChannel();
    }

    private void crearNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            String name = (NOTIFICATION_CHANNEL);
            String description = "Descripcion";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel("Canal", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void register() {

        MyBroadcastReceiver broadcastReceiver = new MyBroadcastReceiver();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BROADCAST_ACTION);
        intentFilter.addAction(AIRPLANE_MODE);

        this.registerReceiver(broadcastReceiver, intentFilter);
    }

}
