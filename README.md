# 서울시립대학교 안드로이드 앱개발 교육

<br>

## 강사 : 김태완

### 홈페이지 : https://floating-tor-96092.herokuapp.com/

<br>

## 2019/1/14 - Simple recyclerview

(강의 효율성을 위해서 Groupie 라이브러리를 사용했습니다.)
<br>

<p align="center">
<img width="243" alt="1" src="https://user-images.githubusercontent.com/37768791/73362499-4bd12680-42ea-11ea-8d7e-0917c01c2217.PNG">
</p>

- ### RecyclerView란?

<br>

```
우리가 흔히 앱에서 볼 수 있는 스크롤 가능한 리스트(인스타그램 피드도 리사이클러뷰)
```

<br>

- ### RecyclerView의 구성(Groupie 고려)

1. 아이템(리스트 안 하나하나)
2. 뷰홀더(아이템 안의 요소를 설정)
3. 어댑터(리사이클러뷰와 뷰홀더 등을 연결)

<br>
<br>

## 2019/1/19 - Two Horizontal RecyclerView

(강의 효율성을 위해서 Groupie 라이브러리를 사용했습니다.)

### 하나가 아닌 두 개의 수평 리사이클러뷰를 제작해봅니다.

<p align="center">
<img width="243" alt="2" src="https://user-images.githubusercontent.com/37768791/73362354-03196d80-42ea-11ea-962d-556d002a804d.PNG">
</p>
<br>

- #### 리사이클러뷰의 제작 순서 (Groupie 라이브러리 기반)

<br>

1. 전체 리사이클러뷰를 배치한다.(이 프로젝트에서는 2개의 리사이클러뷰를 나란히 배치)
2. 리사이클러뷰에 들어갈 아이템을 디자인한다.
3. 위 과정을 마치면 Item클래스를 만들어준다.(아이템 클래스에서는 2번에서 만든 레이아웃 연결과 그 레이아웃 요소들을 코틀린 코드와 연결해준다.)
4. MainActivity클래스로 돌아와서 변수 선언과 초기화를 해준다.(사용할 변수는 레이아웃 2개, 어댑터 2개)
5. 리사이클러뷰의 스크롤 방향을 설정할 수 있는 "레아이웃 매니저"를 세팅해준다.
6. 어댑터에 데이터를 추가해준다.(추가할 땐 Item클래스 이용)
7. 리사이클러뷰와 어댑터와 연결해준다.

<br>

## 2019/1/29 - Splash Screen

<br>

### Splash Screen이란?

<br> : 앱을 실행했을 때 앱의 로고가 나오면서 로딩이 되는 화면을 스플래쉬 스크린이라고 합니다. 로고가 페이드인될 수도 있고 그냥 가만히 나올 수도 있고 아니면 로고가 움직이는 애니메이션을 넣는 등 이펙트는 다양하게 할 수 있습니다. 이 화면이 필요한 이유는 이 화면으로 데이터를 가져오는 작업을 UI로 띄우지 않기 위해 덮어씌우는 역할을 한다고 보면 됩니다. 보통은 사용자 정보를 가져오는 작업을 주로 합니다.

<p align="center">
  <img width="243" alt="3" src="https://user-images.githubusercontent.com/37768791/73361524-73bf8a80-42e8-11ea-8016-9fa32fbc35ae.PNG">

</p>

### 제작 순서

<br>

1. 스플래쉬 스크린에 들어갈 이미지와 로딩바를 디자인합니다.
2. 페이드인 애니메이션을 제작합니다.
3. 로고 이미지와 애니메이션을 연동합니다.
4. 애니메이션이 끝날 때 시점에서 숨긴 로딩바를 보여줍니다.
5. 동시에 타이머를 작동하고 타이머가 종료될 시점에 다음 창으로 이동합니다.(기존에는 Thread.sleep을 사용했었지만 비추합니다...ㅠ)

<br>

## <3주 강습 후 학우분께서 만드신 결과물!>

: 화훼 관련 쇼핑몰 느낌의 앱 디자인입니다.

<p align="center">
<img width="150" alt="1" src="https://user-images.githubusercontent.com/37768791/75609764-97c3f500-5b4e-11ea-80f9-700f5500c0e6.png">
<img width="150" alt="1" src="https://user-images.githubusercontent.com/37768791/75609763-95fa3180-5b4e-11ea-99da-524a4c00001f.png">
<img width="150" alt="1" src="https://user-images.githubusercontent.com/37768791/75609717-50d5ff80-5b4e-11ea-87bc-0cbca7379187.png">
</p>

</br>

## 2020/02/08 - Firebase Login

: 구글 파이어베이스 프레임워크를 이용해서 로그인 기능을 구현해봅시다.

<br>

<p align="center">
  <img width="243" alt="2020-02-08 15;35;47" src="https://user-images.githubusercontent.com/37768791/74080617-2e8a1e00-4a89-11ea-8144-51169fb83d05.PNG">
</p>

 <br>

### 제작순서

1.  구글 파이어베이스 콘솔에 들어가서 프로젝트를 등록해줍니다.
2.  프로젝트에서 안드로이드 앱을 추가적으로 생성해줍니다. (여기 내에서 하라는대로 진행하면 됩니다.)
3.  추가적인 디펜던시를 gradle에 추가합니다.
4.  로그인하고자 하는 액티비티에 가서 우선 페이지 디자인을 해줍니다.
5.  디자인이 끝나면 Kotlin파일로 들어와서 로그인 할때 본인이 원하는 로그인 방식을 리스트에 추가해줍니다.
6.  로그인이 시작되는 함수를 넣어줍니다.(파이어베이스 문서 참고)
7.  로그인이 시작되고 나서 그걸 받는 onAcitivyResult 함수 안에서 로그인 후에 이루어질 작업에 대해서 처리합니다.

## 2020/02/15,22 - Realm Database Memo App

: Realm이라는 내장 데이터베이스를 이용해서 간단한 메모장 앱을 만들어봅시다.

<br>

<p align="center">
  <img width="243" alt="2020-02-15 15;36;30" src="https://user-images.githubusercontent.com/37768791/74583394-0ad75280-500a-11ea-8425-5debef33a980.PNG">
  <img width="243" alt="2020-02-15 15;36;46" src="https://user-images.githubusercontent.com/37768791/74583406-188cd800-500a-11ea-87a3-b49ac6d38645.PNG">
</p>

 <br>

### 제작순서

1.  Realm 공식문서로 가서 디펜던시 설치와 Groupie 깃헙으로 가서 디펜던시 설치를 해줍니다.
2.  xml디자인부터 해줍니다. 위 사진처럼 리스트가 나오는 부분과 메모를 추가하는 부분 UI를 디자인해줍니다.
3.  메모 모델을 만들어줍니다. 데이터가 충돌나지 않고 구분하기 쉽게 Primary Key의 id를 넣어줍니다.
4.  리스트 나오는 부분에서는 RecyclerView를 세팅해줍니다.
5.  Realm에서 데이터를 가져올 때 객체 generic의 RealmResult로 반환되는데, 리스트로 변환하여 for반복문으로 adapter에 데이터를 넣어줍니다.
6.  메모를 추가하는 액티비티에서는 글자를 입력한 경우에만 제출버튼을 눌렀을 때 Realm 데이터베이스에 저장되도록 합니다.

<br>

- 추가적인 Realm 데이터베이스에 대한 궁금한 사항은 아래 블로그에서 확인하시면 됩니다.(포스팅 중 ㅎㅎ)<br>
  https://blog.naver.com/ljk041180/221809549714

</br>

## 2020/03/01,09 - Multi Image Picker + Staggered

: 갤러리에서 이미지 하나가 아닌 "여러개"를 가져와서 인스타그램(?)처럼 띄우는 앱을 만들어보겠습니다.

<p align="center">
<img width="243" alt="2020-02-29 23;08;16" src="https://user-images.githubusercontent.com/37768791/75609143-82989780-5b49-11ea-88d3-fc28e94281e3.PNG">
<img width="243" alt="2020-02-29 23;08;41" src="https://user-images.githubusercontent.com/37768791/75609162-a065fc80-5b49-11ea-87f5-a766a2418974.PNG">
</p>
</br>

### 제작순서

1. 많은 리사이클러뷰를 제작했기 때문에 이전처럼 동일하게 Groupie라이브러리를 이용해서 만들어줍니다.
2. 리사이클러뷰 아이템을 디자인할 때는 주의할 점이 width는 match-parent로 height는 wrap-content로 해줍니다.
3. 2번에 이어서 ImageView에 adjustViewBounds속성에 true값을 넣어주고, maxHeight를 200dp로 설정합니다.(이렇게 안하면 이미지의 높이가 너무 길게 나옵니다.)
4. MainActivity.kt로 돌아와서 intent로 갤러리에 진입하는 코드를 적어주고 갤러리에 진입하는 순간에 EXTRA_ALLOW_MULTIPLE 속성을 넣어서 이미지를 여러개 선택할 수 있게 설정합니다.
5. onActivityResult에서 선택한 이미지들을 for반복문으로 uri를 가져와서 bitmap으로 변환합니다.
6. 변환한 bitmap을 모두 GroupAdapter에 add해줍니다.(bitmap으로만 넣는 이유는 따로 저장하지 않기 때문입니다.)
   </br>
   \*\*따로 저장하려면 데이터베이스를 이용해서 binary를 내장디비에 저장하거나 원격디비에 저장 후 url을 받아와서 glide로 띄우면 됩니다.

7. 이미지를 가져올 때마다 가져온 이미지들을 반응해서 띄우려면 notifysetDataChanged를 해줍니다.
8. recyclerView 레이아웃 매니저 설정을 이전 앱들과는 다르게 StaggeredGridLayoutManager로 설정합니다.

</br>

## 2020/03/15 - Simple Bank App

: 토스앱처럼 간단히 원격 Database를 이용해서 내 계좌에서 출금과 입금의 과정을 구현해봅니다.(실제 계좌 아님)

<p align="center">
<img width="243" alt="cardapp" src="https://user-images.githubusercontent.com/37768791/76642613-e5048580-6596-11ea-90be-3ced11c1de6e.PNG">
<img width="243" alt="cardapp2" src="https://user-images.githubusercontent.com/37768791/76642617-e6ce4900-6596-11ea-94b6-4b3a72359198.PNG">

</p>
</br>

### 사용한 라이브러리

https://github.com/robinhood/ticker

</br>

### 제작순서

1. 구글 파이어베이스 홈페이지로 가서 프로젝트를 생성해줍니다. 생성한 프로젝트와 앱을 연동해주고 여기서 Firestore라는 데이터베이스 인스턴스만 사용할 것이므로 Document에 따라 gradle에 설치해줍니다.
2. 파이베이스 세팅이 끝났으면 카드뷰를 이용해서 위와 같이 숫자가 나오는 부분, 송금버튼, 입금 버튼을 만들어줍니다.
3. 우선 파이어스토어에 초기 데이터를 넣어줍니다.
4. 3번 과정에서 넣은 데이터를 가져오기 위해 addSnapshotListener를 이용해서 실시간 데이터 fetching을 합니다. (실시간으로 가져와야 UI가 그때그때 자동으로 업데이트됩니다.)
5. 송금 과정을 위해서 기존 데이터베이스에 있는 데이터에 특정값을 뺀 값으로 다시 Firestore에 업로드해줍니다.
6. 입금 과정은 5번과 반대로 특정값을 더해주면 됩니다.

## 2020/03/29 - OCR Credit Card

: 인공지능 기반 텍스트 추출을 이용해서 사진에서 체크 카드 번호를 추출해봅니다.

<p align="center">
<img width="273" alt="2020-03-29 02;08;51" src="https://user-images.githubusercontent.com/37768791/77829188-c5a75400-7163-11ea-9b72-dc774bb72058.PNG">
</p>
사진에 있는 카드 번호는 샘플번호입니다. 실제와 무관합니다.
</br>

</br>

### 제작순서

1. 구글 파이어베이스 ML키트를 이용하기 위해서 gradle에 라이브러리를 추가해줍니다.
2. 이미지뷰, 갤러리 접근 버튼, 추출 버튼, 추출된 텍스트가 보여지는 뷰를 디자인해줍니다.
3. 코틀린 파일로 돌아와서 갤러리 접근해서 이를 비트맵으로 변환 후 imageView에 넣어주는 작업을 합니다.
4. 이미지가 들어온 경우에만 실행되게 하고, FirebaseVision을 이용해서 이미지에서 텍스트를 추출합니다.
5. 정규표현식 regex를 이용해서 추출된 텍스트 중 카드번호 양식에 맞다면 토스트를 띄워줍니다.
