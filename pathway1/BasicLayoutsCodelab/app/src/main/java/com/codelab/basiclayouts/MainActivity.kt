/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codelab.basiclayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelab.basiclayouts.ui.theme.MySootheTheme
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MySootheApp() }
    }
}

// Step: Search bar - Modifiers
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    // Implement composable here
    // TextField 구현
    TextField(
        value = "",
        onValueChange = {},
        // TextField 아이콘 설정
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search, // 벡터 이미지
                contentDescription = null           // 이미지 사용시 설명글
            )
        },
        // 색상 속성은 텍스트 필드 기본 속성 중 배경 값을 변경
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        // placeholder 는 Text UI 를 속성값으로 받음
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        },

        // modifier 통해 UI 크기 지정
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

// Step: Align your body - Alignment
// 구성요소 UI 구현
@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,     // 각각의 아이템별로 적용할 이미지 리소스 
    @StringRes text: Int,           //  String 리소스
    modifier: Modifier = Modifier
) {
    // Implement composable here
    
    // Vertical LinearLayout 처럼 구현하기위해 Column 사용
    // 하위 항목을 수직 순서로 배치하는 구성 가능한 레이아웃
    Column(
        // 정렬 속성 지정
        // 상위뷰에서 하위 컴포저블의 정렬 지정
        horizontalAlignment = Alignment.CenterHorizontally, // 중앙정렬
        modifier = modifier
    ) {
        // 상단 이미지뷰
        Image(
            // 이미지 리소스 설정
            painter = painterResource(R.drawable.ab1_inversions),
            contentDescription = null,
            contentScale = ContentScale.Crop,   // ImageView scaleType
            modifier = Modifier     // Modifier 로 크기 설정 및 clip 형태 설정
                .size(88.dp)
                .clip(CircleShape)  // 컴포저블의 모양을 조정
        )
        // 하단 텍스트뷰
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.h3,
            modifier = Modifier.paddingFromBaseline(
                top = 24.dp, bottom = 8.dp
            )
        )
    }
}

// Step: Favorite collection card - Material Surface
// 그리드 뷰로 구현할 카드 UI 구현
@Composable
fun FavoriteCollectionCard(
    // 아이템에 들어갈 리소스를 인자로 설정
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    // Implement composable here

    Surface(
        shape = MaterialTheme.shapes.small,     // UI shape 속성
        modifier = modifier
    ) {
        // 하위 UI 를 가로로 정렬 하기위해 Row 사용
        // 구현 방법은 Column 과 같음
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.fc2_nature_meditations),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = stringResource(R.string.fc2_nature_meditations)
            )
        }
    }
}

// Step: Align your body row - Arrangements
@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    // Implement composable here
    // 같은 UI 여러개를 가로로 구현하기위해 
    // LazyRow 사용
    LazyRow(
        // 아이템 사이의 정렬 방식 설정 및 LazyRow UI padding 설정
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),        
        modifier = modifier
    ) {
        // 미리 설정한 리스트 형태의 데이터를 전달하여 아이템 UI 구현
        // recyclerView 의 ViewHolder
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(item.drawable, item.text)
        }
    }
}

// Step: Favorite collections grid - LazyGrid
@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    // Implement composable here
    // 그리드뷰를 구현 하기 위해 LazyHorizontalGrid 사용
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),  // 열 갯수
        contentPadding = PaddingValues(horizontal = 16.dp), // 그리드뷰 padding
        horizontalArrangement = Arrangement.spacedBy(8.dp), // 가로 배치 속성
        verticalArrangement = Arrangement.spacedBy(8.dp),   // 새로 배치 속성
        modifier = modifier.height(120.dp)  // 세로 크기 지정
    ) {
        // 그리드 뷰 ViewHolder
        items(favoriteCollectionsData) { item ->
            FavoriteCollectionCard(
                drawable = item.drawable,
                text = item.text,
                modifier = Modifier.height(56.dp)
            )
        }
    }
}

// Step: Home section - Slot APIs
// HomeSection 뷰에 인덱스 텍스트뷰 추가
@Composable
fun HomeSection(
    @StringRes title: Int,  // 섹션 텍스트 리소스
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit // content 뷰는 Composable 인자로 설정

) {
    // Implement composable here
    // 세로로 텍스트 뷰와 컨텐츠 뷰로 구성
    Column(modifier) {
        // 섹션 타이틀에 대한 텍스트 속성 지정
        Text(
            text = stringResource(title).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

// Step: Home screen - Scrolling
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    // Implement composable here
    // 각각 구현된 Composable UI 를 세로로 정렬
    // Modifier 를 통해 UI 크기와 padding 지정
    Column(modifier
        .verticalScroll(rememberScrollState())  // Column UI 에 스크롤 속성 지정
        .padding(vertical = 16.dp)
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid()
        }
        Spacer(Modifier.height(16.dp))
    }
}

// Step: Bottom navigation - Material
@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    // Implement composable here
    
    // 하단 BottomNavigation UI 구현
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,  // 백그라은두 설정
        modifier = modifier

    ) {
        // 네비게이션 아이템 구현 
        // 갯수별로 구현하면됨 
        BottomNavigationItem(
            // 아이콘 설정
            icon = {
                Icon(
                    imageVector = Icons.Default.Spa,    //벡터이미지
                    contentDescription = null
                )
            },
            label = {
                // 라벨 텍스트 설정
                Text(stringResource(R.string.bottom_navigation_home))
            },
            selected = true,    // 초기 선택 여부
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_profile))
            },
            selected = false,
            onClick = {}
        )
    }

}

// Step: MySoothe App - Scaffold
@Composable
fun MySootheApp() {
    // Implement composable here
    // 화면의 UI 테마 적용
    MySootheTheme {
        // Scaffold : Composable 의 최상위 뷰 (기본 뷰)
        // 기본 뷰 위에
        Scaffold(
            bottomBar = { SootheBottomNavigation() }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}

private val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { DrawableStringPair(it.first, it.second) }

private val favoriteCollectionsData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun SearchBarPreview() {
    MySootheTheme { SearchBar(Modifier.padding(8.dp)) }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun AlignYourBodyElementPreview() {
    MySootheTheme {
        // 적용할 리소트 전달
        AlignYourBodyElement(
            text = R.string.ab1_inversions,
            drawable = R.drawable.ab1_inversions,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun FavoriteCollectionCardPreview() {
    MySootheTheme {
        FavoriteCollectionCard(
            // 아이템에 들어갈 리소스 전달
            text = R.string.fc2_nature_meditations,
            drawable = R.drawable.fc2_nature_meditations,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun FavoriteCollectionsGridPreview() {
    MySootheTheme { FavoriteCollectionsGrid() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun AlignYourBodyRowPreview() {
    MySootheTheme { AlignYourBodyRow() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun HomeSectionPreview() {
    MySootheTheme {
        // 홈 섹션 뷰에 인텍스 타이틀 텍스트와 컨텐츠로 사용한 Composable 를 념겨준다
        // 람다 형식으로 인자 넘김
        HomeSection(R.string.align_your_body) {
            AlignYourBodyRow()
        }
    }
}

//@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
// 미리 보기에서는 높이를 제한하여 스크롤을 확인
@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2, heightDp = 180)
@Composable
fun ScreenContentPreview() {
    MySootheTheme { HomeScreen() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun BottomNavigationPreview() {
    MySootheTheme { SootheBottomNavigation(Modifier.padding(top = 24.dp)) }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun MySoothePreview() {
    MySootheTheme { MySootheApp() }
}
