# Project : BlackServival mini game

# Environment
### Java : 11.0.4(LTS)
### Ecliplse : 2019-06(4.12.0)

# Project Summary
### Period : 2019.08.13 ~ 08.15
### 블랙서바이벌 게임, 던전 앤 드래곤을 모티브로 제작된 rpg게임. 턴제 요소가 있으며, 그래픽적 요소는 없음.
### (eng) I made it based on "black servival game", "dungeon & dragon(board game)". There is some material "Turn-based strateg". There isn't any graphical material.

# Class Summary

## BlackRun : 
### 런쳐 역할을 하는 클래스
### (eng)It is Laungher

## BlackServival : 
### 가장 중요한 클래스. 런처를 통해 실행되므로 런처에서 이 클래스의 인스턴스를 생성해서 접근해야 한다
### (eng)Most important class. It started on BlackRun(launcher) so you must make this class's instance on BlackRun.

## CharInfo : 
### 캐릭터의 스탯을 설정할 때 필요한 변수들을 적은 클래스
### (eng)use for setting each character's status.

## Character extends CharInfo : 
### 캐릭터의 스탯 설정, 아이템 변화에 관여하는 클래스
### (eng)use for setting character and items. 

## Monster extends CharInfo : 
### 몬스터의 스탯 설정에 관여하는 클래스
### (eng)use for setting monster

# Function Summary

## class BlackRun 
### main만 있습니다. 런처역할이기 때문입니다.
### There is only main. Because This is launcher

## class BlackServival

### public String choiceChar() : 최초시작시, 캐릭터를 선택합니다
### When you started, It makes you to choice character.

### public Character generateChar(String use_name) : 
### 캐릭터를 선택후 그에 맞게 캐릭터의 능력이 결정됩니다
### When you select character, this method generate character status as you select.

### public void moveArea() throws InterruptedException : 
### [2]지역이동 선택시 벌어지는 일들에 관한 함수입니다
### When you choose [2]지역이동, this class will express move area situation

### public void explore(Character chinfo) throws InterruptedException : 
### [1]탐험 선택시 벌어지는 일들에 관한 함수입니다. 몬스터조우, 아이템획득, 경험치 획득, 아무것도 없음 
### 총 네 가지의 상황이 구현됐으며, 각 25%확률입니다
### When you choose [1]탐험, this class will active. this class generate some situation. 
### fight monster, gain item, gain Exp, gain nothing. And each chance is 25%.

### public void itemControl(Character chinfo) :
### [3]아이템 사용 을 선택했을때 일어나는 함수입니다
### When you choose [3]아이템 사용.this class will active. this class search your itemBox. 
### if there are some item, you can descide use or not use. 
### but there are not any item, you can't. And don't foreget, your itemBox's maximum is 3.

### public void itemGain(Character chinfo) :
### 모험중, 아이템 획득시처리에 관여하는 함수 입니다
### When you choose explore, this method help gain item situation.

### public void start() throws InterruptedException : 
### 게임 실행시, 메인 UI를 호출하게 하는 함수입니다.
### when you play this game, this is your main UI.

## class Character extends CharInfo
### getter 와 setter밖에 없는 클래스이지만, 필드중에 자료형이 ArrayList인 것이 있습니다. 
### 따라서 ArrayList의 메서드를 활용해 구현한 부분도 있습니다
### There is just getter & setter. But I will just one minute. 
### itemBox is ArrayList, so i set ArrayList method.

## abstract class CharInfo
### 필드변수만 존재합니다
### There is just field.

## class Monster extends CharInfo
### getter와 setter만 존재합니다
### There is just getter & setter


