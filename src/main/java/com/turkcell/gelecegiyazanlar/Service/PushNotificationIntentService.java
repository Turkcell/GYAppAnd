package com.turkcell.gelecegiyazanlar.Service;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.turkcell.gelecegiyazanlar.Activity.MainActivity;
import com.turkcell.gelecegiyazanlar.R;

/**
 * !!!!!
 *
 * Important: This is just a sample reference implementation.
 *
 * Please DO NOT copy and paste this class and code to your real life projects,
 * since it may cause issues on your project.
 *
 * Please write your own code and implementation.
 *
 * !!!!!
 */
public class PushNotificationIntentService extends IntentService {

	private int notificationId;
	private NotificationManager notificationManager;

	public PushNotificationIntentService() {
		super("PushNotificationIntentService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Bundle extras = intent.getExtras();
		GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
		String messageType = gcm.getMessageType(intent);
		
		Log.w("PushIntentSerivce", extras.toString());

		if (!extras.isEmpty()) {
			String from = extras.getString("from");

			if (!from.equals("google.com/iid") && GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) {
				createNotification(extras);
			}
		}

		PushNotificationBroadcastReceiver.completeWakefulIntent(intent);
	}

	/**
	 * Create notification after push received.
	 * 
	 * @param extras
	 */
	private void createNotification(Bundle extras) {
		String message = extras.getString("collapse_key");
		notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

		Intent notificationIntent = new Intent(this, MainActivity.class);
		notificationIntent.putExtras(extras);

		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

		NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_logo).setContentTitle("Geleceði Yazanlar").setContentText(message);

		notificationBuilder.setContentIntent(contentIntent);
		notificationBuilder.setAutoCancel(true);
		Notification notification = notificationBuilder.build();
		notification.defaults |= Notification.DEFAULT_VIBRATE;

		notificationManager.notify(notificationId, notification);
		notificationId++;
	}
}