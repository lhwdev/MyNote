package com.lhwdev.compose.materialapp.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lhwdev.compose.materialapp.AppInfo
import com.lhwdev.compose.materialapp.AppRouteId
import com.lhwdev.compose.materialapp.AppRouteInfo
import com.lhwdev.compose.materialapp.invoke
import com.lhwdev.compose.materialapp.repository.Note
import com.lhwdev.compose.materialapp.repository.getDefaultNoteProvider
import com.lhwdev.compose.navigation.navigationState
import com.lhwdev.compose.navigation.pushRoute


val HomeRoute = AppRouteId<Unit>(info = AppRouteInfo(title = AppInfo.title, isRoot = true), name = "Home") {
	Home()
}


@Composable
fun Home() {
	var notes by remember { mutableStateOf<List<Note>?>(null) }
	
	LaunchedEffect(null) {
		notes = getDefaultNoteProvider().getNotes()
	}
	
	val noteList = notes
	if(noteList == null) Box {
		Text("Loading", modifier = Modifier.align(Alignment.Center))
	} else LazyColumn(modifier = Modifier.padding(3.dp)) {
		items(noteList) {
			NotePreviewCard(it)
		}
	}
}

@Composable
fun NotePreviewCard(note: Note) {
	val navigator = navigationState
	
	Card(
		modifier = Modifier.fillMaxWidth().padding(5.dp).clickable {
			navigator.pushRoute(NoteViewRoute(note))
		}
	) {
		Column {
			Text(note.info.title, style = MaterialTheme.typography.h4)
			Text(note.info.description, style = MaterialTheme.typography.body1)
		}
	}
}


