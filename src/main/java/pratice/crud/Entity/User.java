package pratice.crud.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity  // JPA 에서 이 클래스를 데이터베이스 테이블로 사용하도록 지정
@Table(name = "person")  // 테이블 이름을 "person"로 지정
@Getter @Setter  // Lombok을 이용해 Getter, Setter 자동 생성
@NoArgsConstructor  // 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 포함하는 생성자 자동 생성
@ToString // 객체 정보를 출력할 때 사용
@Builder

public class User {
    @Id  // 기본 키 (Primary Key) 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ID 자동 증가
    private Long id;

    @Column(nullable = false)  // name 필드는 null 이 될 수 없음
    private String name;

    @Column(nullable = false, unique = true)  // email 필드는 유니크하고 null이 될 수 없음
    private String email;
}



