# 🛠️ java 프로젝트 리팩토링
<br>

## 📚 목차
### 특징
### 스크린샷
### 저장소 클론
### 리팩토링 내용
<br>
<br>
<br>

🎉 프로젝트 리팩토링은 코드의 가독성과 유지보수성을 향상시키기 위한 목적입니다. 기존의 코드를 개선하고, 구조를 재정비하며, 성능을 최적화하는 것을 목표로 하였습니다.
<br>
<br>

## 특징
### ✨ 주요 기능:
성능 최적화: 기존의 for 반복문을 Stream API로 변경하여 성능 향상
코드 가독성 향상: Arrays.asList를 사용하여 생성자 가독성 개선 및 주석 추가
<br>
<br>
<br>

## 🖼️ 스크린샷:
<br>
<br>
<br>

## 저장소 클론
bash
`git clone https://github.com/yourusername/project-refactoring.git](https://github.com/ohwoong2/java_refactoring.git`
<br>
<br>
<br>

## 리팩토링 내용
### 🔧 리팩토링 작업:
`TalentDonationProjectService.java` - `donationProjectUpdate`
``` java
/* 기존 코드 */
for (TalentDonationProject project : donationProjectList) {
            if (project != null && project.getTalentDonationProjectName().equals(projectName)) {
                if (people != null) {
                    project.setProjectDonator(people);
                    break;
                } else {
                    throw new Exception("프로젝트 이름은 있으나 기부자 정보 누락 재확인 하세요");
                }
            } else {
                throw new Exception("프로젝트 이름과 기부자 정보 재 확인 하세요");
            }
}
```

``` java
/* 수정 코드 */
Optional<TalentDonationProject> projectOptional = donationProjectList.stream()
            .filter(project -> project != null && project.getTalentDonationProjectName().equals(projectName))
            .findFirst();

        if (projectOptional.isPresent()) {
            TalentDonationProject project = projectOptional.get();
            if (people != null) {
                project.setProjectDonator(people);
            } else {
                throw new Exception("프로젝트 이름은 있으나 기부자 정보 누락 재확인 하세요");
            }
        } else {
            throw new Exception("프로젝트 이름과 기부자 정보 재 확인 하세요");
        }
```
`TalentDonationProjectService.java` - `beneficiaryProjectUpdate`

``` java
/* 기존 코드 */
for (TalentDonationProject project : donationProjectList) {
            if (project != null && project.getTalentDonationProjectName().equals(projectName)) {
                project.setProjectBeneficiary(people);
                break;
            }
        }

```

``` java
/* 수정 코드*/
Optional<TalentDonationProject> projectOptional = donationProjectList.stream()
            .filter(project -> project != null && project.getTalentDonationProjectName().equals(projectName))
            .findFirst();

        if (projectOptional.isPresent()) {
            TalentDonationProject project = projectOptional.get();
            project.setProjectBeneficiary(people);
        } else {
            throw new Exception("프로젝트 이름과 수혜자 정보 재 확인 하세요");
}
```
