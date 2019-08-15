# Project : BlackServival mini game

# Environment
### Java : 11.0.4(LTS)
### Ecliplse : 2019-06(4.12.0)

# Project Summary
### Period : 2019.08.13 ~ 08.15
### 블랙서바이벌 게임, 던전 앤 드래곤을 모티브로 제작된 rpg게임. 턴제 요소가 있으며, 그래픽적 요소는 없음.
### (eng) I made it based on "black servival game", "dungeon & dragon(board game)". There is some material "Turn-based strateg". There isn't any graphical material.

# Class Summary

### BlackRun : 런쳐 역할을 하는 클래스_(eng)It is Laungher
### BlackServival : 가장 중요한 클래스. 런처를 통해 실행되므로 런처에서 이 클래스의 인스턴스를 생성해서 접근해야 한다_(eng)Most important class. It started on BlackRun(launcher) so you must make this class's instance on BlackRun.
### CharInfo : 캐릭터의 스탯을 설정할 때 필요한 변수들을 적은 클래스_(eng)use for setting each character's status.
### Character extends CharInfo : 캐릭터의 스탯 설정, 아이템 변화에 관여하는 클래스_(eng)use for setting character and items. 
### Monster extends CharInfo : 몬스터의 스탯 설정에 관여하는 클래스_(eng)use for setting monster

# Function Summary

## class BlackRun 
### There is only main. Because This is launcher

## BlackServival
### public String choiceChar() : When you started, It makes you to choice character.

### public Character generateChar(String use_name) : When you select character, this method generate character status as you select.

### public void moveArea() throws InterruptedException : When you choose [2]지역이동, this class will express move area situation

### public void explore(Character chinfo) throws InterruptedException : When you choose [1]탐험, this class will active. this class generate some situation. fight monster, gain item, gain Exp, gain nothing. And each chance is 25%.

### public void itemControl(Character chinfo) : When you choose [3]아이템 사용.this class will active. this class search your itemBox. if there are some item, you can descide use or not use. but there are not any item, you can't. And don't foreget, your itemBox's maximum is 3.

### public void itemGain(Character chinfo) : When you choose explore, this method help gain item situation.

### public void start() throws InterruptedException : when you play this game, this is your main UI.

## class Character extends CharInfo
### There is just getter & setter. But I will just one minute. itemBox is ArrayList, so i set ArrayList method.

## abstract class CharInfo
### There is just field.

## class Monster extends CharInfo
### There is just getter & setter


