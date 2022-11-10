package com.codelab.basics

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelab.basics.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* study 한 코드 주석처리
        // 기존에는 setContent 에 xml 리소스 또는 binding 뷰를 호출했지만
        // compose 구성 가능한 함수를 호출합니다.
//        setContent {
//
//            // BasicsCodelabTheme 은 구성 가능한 함수의 스타일을 지정하는 방법
//            BasicsCodelabTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Greeting("Android")
//                }
//            }
//        }*/

        setContent {
            BasicsCodelabTheme {
                MyApp()
            }
        }
    }
}

/**********************************************************************************************************/
/* study 한 코드 주석처리
@Composable // compose UI 구성함수
fun Greeting(name: String) {
    // 기존 TextView 에 해당하는 compose UI 구성함수
//    Text(text = "안녕하세요 $name!")

    // UI 배경에 테마색이 아닌 다른 배경 색상을 설정
    // 머티리얼 구성요소는 앱에 넣고자 하는 공통 기능
    // (예: 텍스트에 적절한 색상 선택)을 처리하여 더 나은 환경을 만들도록 빌드됩니다.
    // Surface : 배경에 대한 설정
//    Surface(color = MaterialTheme.colors.primary) {
//        Text(text = "안녕하세요 $name!")
//    }

    // margin 과 padding 설정은 Modifier (조정자)를 통해서 설정
//    Surface(color = MaterialTheme.colors.primary) {
//        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
//
//    }

    // Compose 수정자 목록
    // https://developer.android.com/jetpack/compose/modifiers-list


//    Surface(color = MaterialTheme.colors.primary) {
//        // 기존 LinearLayout 에 해당하는 compose UI 구성함수
//        Column(modifier = Modifier.padding(24.dp)) {
//            Text(text = "Hello,")
//            Text(text = name)
////            Text("GOOD !!!")
//        }
//    }

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            // margin 이 필요하다면 상위 뷰 또는 Surface 배경에서 padding 을 주든지


    ) {
//        Column(modifier = Modifier.fillMaxWidth().padding(24.dp)) {
//            Text(text = "Hello, ")
//            Text(text = name)
//        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)

        ) {
            Text(text = "Hello, ")
            Text(text = name)
        }
    }
}*/

/* study 한 코드 주석처리

@Composable
private fun Greeting(name: String) {

    // mutableStateOf : UI 상태값을 저장하는 함수
    // remember : UI 업데이트(리컴포지션) 시 계산된 상태값을 반환
//    val expanded = remember { mutableStateOf(false) }
    // by 를 사용하여 remember 상태값을 가져온다
    //var expanded by remember { mutableStateOf(false) }

    // 이것도 상태값 유지하기 위한 rememberSaveable
    var expanded by rememberSaveable { mutableStateOf(false) }

    // 상태 값에 따른 padding dp값
//    val extraPadding = if (expanded.value) 48.dp else 0.dp

    // 상태 값에 따른 애니메이션 효과 추가
    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp,
        // 애니메이션의 속성 지정 (spring 이란 바운스 효과 지장)
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
//                .padding(bottom = extraPadding) // bottom padding 적용
                .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = "Hello, ")
//                Text(text = name)
                // MaterialTheme 텍스트 스타일 로 지정
                // 머티리얼에 정의된 텍스트 스타일(h1-h6, body1,body2, caption, subtitle1 등)
//                Text(text = name, style = MaterialTheme.typography.h4)

                //
                Text(text = name,
                    // 미리 정의된 스타일을 확장하여 수정할수 있음
                    style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
            }
            // 기본 버튼 UI를 상속한 Material 버튼 UI (아웃라인 Border 가 있음)
            OutlinedButton(
                // 클릭 시 실행할 작업을 람다 식으로 작성
                // 클릭 시 마다 상태 플래그 값을 변환
//                onClick = { expanded.value = !expanded.value },
                onClick = { expanded = !expanded }
            ) {
                //Text("Show more")
                // 상태 값에 따른 텍스트 변경
                Text(if (expanded) "Show less" else "Show more")
            }
        }
    }
}
*/


/**********************************************************************************************************/
/* study 한 코드 주석처리

// 미리보기를 사용하려면 @Preview 어노테이션 설정
// Preview 이름설정도 가능
// showBackground : 기본 백그라운 색상 사용 여부 (현재 기본색상 : white)
//@Preview(showBackground = true, name = "Text preview")
//@Composable
//fun DefaultPreview() {
//    // Theme.kt 에 구현되어 있는 테마 설정
//    BasicsCodelabTheme {
//        Greeting("Android")
//    }
//}
*/

// Preview 통해 적용된 UI를 미리 확인할 수 있음
// 2개의 Preview 생성됨
@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    BasicsCodelabTheme {
        MyApp()
    }
}


/**********************************************************************************************************/

/* study 한 코드 주석처리
// 재사용을 위한 composable 함수
//@Composable
//private fun MyApp() {
//    Surface(color = MaterialTheme.colors.background) {
//        Greeting("Android")
//    }
//}

//@Preview
//@Composable
//fun MyApp(names: List<String> = listOf("World", "Compose")) {
////    Column {
////        for (name in names) {
////            Greeting(name = name)
////        }
////    }
//
//    Column(modifier = Modifier.padding(vertical = 4.dp)) {
//        for (name in names) {
//            Greeting(name = name)
//        }
//    }
//}


//@Composable
//fun MyApp(names: List<String> = listOf("World", "Compose")) {
//    Column(modifier = Modifier.padding(vertical = 4.dp)) {
//        for (name in names) {
//            Greeting(name = name)
//        }
//    }
//}
*/


/**********************************************************************************************************/
//  MyApp의 콘텐츠를 Greetings라는 새 컴포저블로 이동
@Composable
fun MyApp() {
    // 상태를 호이스팅
    //var shouldShowOnboarding by remember { mutableStateOf(true) }

    // 화면 회전이나 프로세스가 중단또는 변경되면 상태가 손실됨
    // 이를 위해 rememberSaveable 사용
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    // 상태 값에 따른 UI 변경
    if (shouldShowOnboarding) {
        OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
    } else {
        Greetings()
    }
}

//@Composable
//private fun Greetings(names: List<String> = listOf("World", "Compose")) {
//    Column(modifier = Modifier.padding(vertical = 4.dp)) {
//        for (name in names) {
//            Greeting(name = name)
//        }
//    }
//}


// 1000 개의 아이템을 생성하도록 생성자 추가
// $it 는 list 인덱스
// 즉 리스트의 인덱스 String 값을 name 으로 지정

@Composable
private fun Greetings(names: List<String> = List(1000) { "$it" } ) {

    // LazyColumn은 화면에 보이는 항목만 렌더링하므로 항목이 많은 목록을 렌더링할 때 성능이 향상
    // LazyRow 도 동일
    // 다만 RecyclerView 처럼 뷰를 재 사용하지는 않음
    // 고정된 연속된 UI 를 나열할 때 유용 할듯
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

/**********************************************************************************************************/

// MyApp의 상태를 변경할 수 있도록 onContinueClicked: () -> Unit으로 정의된 온보딩 화면에 함수 매개변수를 추가
@Composable
fun OnboardingScreen(onContinueClicked: () -> Unit) {
    // TODO: This state should be hoisted
//    // 상태값을 관리하는 함수를 상위 항목으로 올려 상태관리를 용이하게 함
//    //  by 키워드를 사용하고 있습니다. 이 키워드는 매번 .value를 입력할 필요가 없도록 해주는 속성 위임
//    var shouldShowOnboarding by remember { mutableStateOf(true) }

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            // 적용될 속성 필드 확인
            verticalArrangement = Arrangement.Center,              // vertical layout_gravity
            horizontalAlignment = Alignment.CenterHorizontally  // horizontal gravity
        ) {
            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                // 매개변수로 받은 MyApp 상태값 적용
//                onClick = { shouldShowOnboarding = false }
                onClick = onContinueClicked
            ) {
                Text("Continue")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    BasicsCodelabTheme {
        //OnboardingScreen()
        // 클릭 상태 매개변수 적용
        OnboardingScreen(onContinueClicked = {}) // Do nothing on click.
    }
}

/**********************************************************************************************************/

@Composable
private fun Greeting(name: String) {
    
    // Card UI 적용
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name)
    }
}

// CardContent 라는 새로운 UI 생성
@Composable
private fun CardContent(name: String) {
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "Hello, ")
            Text(
                text = name,
                style = MaterialTheme.typography.h4.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            if (expanded) {
                Text(
                    text = ("Composem ipsum color sit lazy, " +
                            "padding theme elit, sed do bouncy. ").repeat(4),
                )
            }
        }

        // 아이콘 버튼 UI
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                // 아이콘에 벡터 이미지로 적용 ( 라이브러리에서 제공하는 벡터이미지)
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                
                contentDescription = if (expanded) {
                    // 버튼 텍스트 적용
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }

            )
        }
    }
}
