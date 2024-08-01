package com.tspoon.androidtoolbelt.component.service

import android.app.IntentService
import android.content.Intent
import android.os.IBinder
import android.os.Messenger
import com.tspoon.androidtoolbelt.utils.BitmapWrapper
import com.tspoon.androidtoolbelt.utils.ByteArrayWrapper
import com.tspoon.androidtoolbelt.utils.MemoryUtils
import timber.log.Timber
import java.util.Random

abstract class MemoryServiceBase(private val serviceName: String) : IntentService(serviceName) {
    private var mRun = false
    private val mBitmapAllocations = ArrayList<BitmapWrapper>()
    private val mMessenger: Messenger = Messenger(MessageHandler(mRun))

    override fun onBind(intent: Intent?): IBinder? {
        Timber.tag(serviceName).d("onBind: %s", intent)
        return mMessenger.binder
    }

    override fun onHandleIntent(intent: Intent?) {
        mRun = true

        try {
            Thread.sleep((50..200).random().toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        while (mRun) {
            Timber.tag(serviceName).d("Attempting Allocation...")
            if (!MemoryUtils.get(applicationContext).isLowMemory) {
                val bitmap = BitmapWrapper((1000..2000).random(),(1000..2000).random())
                mBitmapAllocations.add(bitmap)
                Timber.tag(serviceName).d("Allocated new block")
                try {
                    Thread.sleep(500)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
    }
}

class MemoryService1 : MemoryServiceBase("MemoryService1")
class MemoryService2 : MemoryServiceBase("MemoryService2")
class MemoryService3 : MemoryServiceBase("MemoryService3")
class MemoryService4 : MemoryServiceBase("MemoryService4")
class MemoryService5 : MemoryServiceBase("MemoryService5")
class MemoryService6 : MemoryServiceBase("MemoryService6")
class MemoryService7 : MemoryServiceBase("MemoryService7")
class MemoryService8 : MemoryServiceBase("MemoryService8")
class MemoryService9 : MemoryServiceBase("MemoryService9")
class MemoryService10 : MemoryServiceBase("MemoryService10")
class MemoryService11 : MemoryServiceBase("MemoryService11")
class MemoryService12 : MemoryServiceBase("MemoryService12")
class MemoryService13 : MemoryServiceBase("MemoryService13")
class MemoryService14 : MemoryServiceBase("MemoryService14")
class MemoryService15 : MemoryServiceBase("MemoryService15")
class MemoryService16 : MemoryServiceBase("MemoryService16")
class MemoryService17 : MemoryServiceBase("MemoryService17")
class MemoryService18 : MemoryServiceBase("MemoryService18")
class MemoryService19 : MemoryServiceBase("MemoryService19")
class MemoryService20 : MemoryServiceBase("MemoryService20")