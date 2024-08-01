// Generated by MemoryServiceWriter.java. Do not modify!
package com.tspoon.androidtoolbelt.component.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import java.lang.Class;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

public final class ServiceHolderImpl implements ServiceHolder {
  private static final List<Class<? extends Service>> SERVICES = new ArrayList<Class<? extends Service>>(){{
  add(MemoryService1.class);
  add(MemoryService2.class);
  add(MemoryService3.class);
  add(MemoryService4.class);
  add(MemoryService5.class);
  add(MemoryService6.class);
  add(MemoryService7.class);
  add(MemoryService8.class);
  add(MemoryService9.class);
  add(MemoryService10.class);
  add(MemoryService11.class);
  add(MemoryService12.class);
  add(MemoryService13.class);
  add(MemoryService14.class);
  add(MemoryService15.class);
  add(MemoryService16.class);
  add(MemoryService17.class);
  add(MemoryService18.class);
  add(MemoryService19.class);
  add(MemoryService20.class);
  }};

  private static final List<MemoryServiceConnection> CONNECTIONS = new ArrayList<>();

  @Override
  public void startServices(Context context) {
    for(Class<? extends Service> service: SERVICES) {
      Intent intent = new Intent(context, service);
      context.startService(intent);

      MemoryServiceConnection connection = new MemoryServiceConnection();
      context.bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
  }

  @Override
  public void stopServices() {
    Timber.tag("MemoryService").d("Stopping Services... " + CONNECTIONS.size() + " connections found.");
    while(CONNECTIONS.size() > 0) {
      CONNECTIONS.remove(0).stopService();
    }
  }
}
