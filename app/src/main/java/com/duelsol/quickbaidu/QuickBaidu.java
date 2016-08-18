package com.duelsol.quickbaidu;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class QuickBaidu extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        for (int appWidgetId : appWidgetIds) {
            // 主要的RemoteViews
            RemoteViews mainViews = new RemoteViews(context.getPackageName(), R.layout.main);
            // 新增按钮的Intent
            Intent intent = new Intent(context, MyActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            mainViews.setOnClickPendingIntent(R.id.layout, pendingIntent);
            mainViews.setImageViewResource(R.id.imgbutton, R.drawable.baidu);
            // 更新widget
            appWidgetManager.updateAppWidget(appWidgetId, mainViews);
        }
    }

}
