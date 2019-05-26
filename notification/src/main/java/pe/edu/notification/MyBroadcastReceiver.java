package pe.edu.notification;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

import java.util.Random;

public class MyBroadcastReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        Intent newIntent = new Intent(context, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, newIntent, 0);

        if (action.equals(MainActivity.BROADCAST_ACTION)) {
            Toast.makeText(context, "Acción ocurrió", Toast.LENGTH_SHORT).show();

            NotificationCompat.Builder notificacion = new NotificationCompat.Builder(context, "Canal")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Notificación nueva")
                    .setContentText("Esta es una nueva notificación")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
            managerCompat.notify(0, notificacion.build());

        }

        if(action.equals(MainActivity.AIRPLANE_MODE)){
            NotificationCompat.Builder notificacion = new NotificationCompat
                    .Builder(context, "Canal")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Notificación modo avión")
                    .setContentText("Cambio a modo avión")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

            Random random = new Random();
            int unique_id = random.nextInt(999);

            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
            managerCompat.notify(unique_id, notificacion.build());
        }
    }
}
