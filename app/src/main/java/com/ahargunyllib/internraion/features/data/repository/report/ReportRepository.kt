package com.ahargunyllib.internraion.features.data.repository.report

import android.content.ContentValues
import android.util.Log
import com.ahargunyllib.internraion.features.data.network.SupabaseClient
import com.ahargunyllib.internraion.features.domain.model.Report
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.storage.storage
import kotlin.time.Duration.Companion.minutes

class ReportRepository (
    private val supabaseClient: SupabaseClient
): IReportRepository {
    override suspend fun uploadFile(
        fileName: String,
        byteArray: ByteArray,
    ) {
        supabaseClient.client.storage.from("images").upload("$fileName.jpg", byteArray, true)
    }

    override suspend fun createReport(report: Report) {
        supabaseClient.client.postgrest.from("reports").insert(report)
    }


}