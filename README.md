# Aqualife
## 창업 동아리 프로젝트
- 개발환경
  - Firebase(Auth, RealtimeDatabase)

## LOG
- 2022.09.18 기본 Activity, Fragment 틀 제작
- 2022.10.06 Fragment 화면 일부 추가
- 2022.10.10 Home, Regulator, Temperature 화면 기능 구현(Firebase 사용)
- 2022.10.17 Ph 화면 기능 구현(Firebase 사용)
- 2022.11.27 Hilt 적용, Fragment View Model 사용 방식 변경
- 2022.12.19 환수 기능 추가, 병합(동료 구현)
- 2023.01.31 Notification 적용(현재 PH 범위 이상)
- 2023.03.04 FCM을 이용한 알림 기능 추가<br>
![test1](https://user-images.githubusercontent.com/97011241/222886263-667fc307-8df4-4abf-a102-b5f356f3f497.png)
- 2023.03.09 생성된 FCM 토큰을 DB에 저장하는 코드 추가, 앱 강제 종료시 onDestory가 호출되지 않아 Firebase signOut이 제대로 동작하지 않는 문제 수정(Service를 상속받을 클래스에서 onTaskRemove 메소드를 오버라이드 하여 FirebaseAuth.getInstance().signOut()을 실행 후 서비스를 종료되게 함)
- 2023.03.17 마지막으로 선택한 어항 인덱스를 저장하고, 재접속시 바로 선택하게 수정합(sharedPreference)
- 2023.03.25 Co2 레귤레이터 동작시 Notification 발생, Notification에 어항 고유 ID를 추가해 이벤트가 발생한 어항을 구분할 수 있게함, Notification을 Group Notification으로 묶음
