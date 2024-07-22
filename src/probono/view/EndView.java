/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  EndView.java
 * DESC  : 재능 기부 정보 출력 클래스
 * 
*/

package probono.view;

import java.util.List;

import probono.model.dto.TalentDonationProject;

public class EndView {
    
    //진행중인 특정 프로젝트 출력 
    public static void projectView(TalentDonationProject project) {
        if (project != null) {
            System.out.println(project);    // project.toString()
        } else {
            System.out.println("해당 프로젝트는 존재하지 않습니다.");
        }
    }
    
    //진행중인 모든 프로젝트 출력
    public static void projectListView(List<TalentDonationProject> allProbonoProject) {
        // 기존 코드
        /*
        int index = 1;
        for (TalentDonationProject project : allProbonoProject) {
            if (project != null) {
                System.out.println("[진행 중인 project : " + (index++) + "] " + project);
            }
        }
        */
        
        // 수정된 코드
        final int[] index = {1};  // 사용하려면 배열을 사용하여 인덱스를 변경 가능하게 만들어야 합니다.
        allProbonoProject.stream()
            .filter(project -> project != null)
            .forEach(project -> System.out.println("[진행 중인 project : " + (index[0]++) + "] " + project));
    }

    public static void successMessage(String message) {
        System.out.println(message);
    }
}