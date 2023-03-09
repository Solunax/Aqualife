package com.project.aqualife

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.google.firebase.auth.FirebaseAuth

class TerminationService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        FirebaseAuth.getInstance().signOut()
        stopSelf()
    }
}