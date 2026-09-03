package com.ghostie.pet

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PetOverlayService : Service() {
    
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    
    override fun onBind(intent: Intent?): IBinder? = null
    
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }
    
    fun sendMessageToPet(userMessage: String, chatHistory: List<Pair<String, String>>) {
        coroutineScope.launch {
            try {
                val response = openAi(
                    key = "your-api-key",
                    history = chatHistory,
                    text = userMessage
                )
                // Handle response
                onPetResponse(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    
    private suspend fun openAi(
        key: String,
        history: List<Pair<String, String>>,
        text: String
    ): String {
        // API implementation goes here
        return "Response from AI"
    }
    
    private fun onPetResponse(response: String) {
        // Update UI with response
    }
    
    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel()
    }
}

@Composable
fun PetChatInput(onSendMessage: (String) -> Unit) {
    var messageText by remember { mutableStateOf("") }
    
    Column {
        TextField(
            value = messageText,
            onValueChange = { messageText = it },
            label = { androidx.compose.material3.Text("Message") },
            maxLines = 1,
            modifier = androidx.compose.foundation.layout.Modifier.fillMaxWidth()
        )
    }
}
