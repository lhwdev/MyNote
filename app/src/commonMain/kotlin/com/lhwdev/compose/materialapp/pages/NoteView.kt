package com.lhwdev.compose.materialapp.pages

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.lhwdev.compose.materialapp.AppRouteId
import com.lhwdev.compose.materialapp.AppRouteInfo
import com.lhwdev.compose.materialapp.repository.Note
import com.lhwdev.compose.materialapp.repository.NoteContent


val NoteViewRoute = AppRouteId<Note>(info = { AppRouteInfo(title = it.info.title) }) {
	NoteView(it)
}


@Composable
fun NoteView(note: Note) {
	when(val content = note.content) {
		is NoteContent.Text -> Text(content.text)
	}
}
