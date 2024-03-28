package br.com.leonardobarral.myapplication.screens


import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.leonardobarral.myapplication.components.BoxComponent
import br.com.leonardobarral.myapplication.models.AnimationModel

@Composable
fun AnimationScreen(animationModel: AnimationModel) {

    val visible by animationModel.visible.observeAsState(initial = true)
    val enter by animationModel.enter.observeAsState(fadeIn())
    val exit by animationModel.exit.observeAsState(fadeOut())


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {


            Button(onClick = {
                animationModel.updateVisible(!visible)
                animationModel.updateEnter(fadeIn(animationSpec = tween(2000)))
                animationModel.updateExit(fadeOut(animationSpec = tween(2000)))
            }) { Text(text = "Fade") }

            Button(onClick = {
                animationModel.updateVisible(!visible)
                animationModel.updateEnter(slideInHorizontally())
                animationModel.updateExit(slideOutHorizontally(animationSpec = tween(1500)) + fadeOut(animationSpec = tween(2000)))
            }) { Text(text = "Slide") }


            Button(onClick = {
                animationModel.updateVisible(!visible)
                animationModel.updateEnter(scaleIn())
                animationModel.updateExit(scaleOut())
            }) { Text(text = "Scale") }


            Button(onClick = {
                animationModel.updateVisible(!visible)
                animationModel.updateEnter(expandIn())
                animationModel.updateExit(shrinkOut())
            }) { Text(text = "Expand") }
        }
        BoxComponent(
            visible = visible,
            enter = enter,
            exit = exit
        )
    }

}



