package pratice.crud.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pratice.crud.DTO.UserDto;
import pratice.crud.Entity.User;
import pratice.crud.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service  // 이 클래스가 서비스 역할을 하는 Bean 임을 나타냄
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // CREATE: 새로운 사용자 저장
    public User saveUser(UserDto userDto) {
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        User user = User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .build();

        return userRepository.save(user);
    }

    // READ: 모든 사용자 조회
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // READ: 특정 사용자 조회(Id)
    public Optional<User> getUserById(Long id) {
        log.info("🔍 getUserById 호출됨: {} ", id);
        return userRepository.findById(id);
    }

    // READ : 특정 사용자 조회(Email)
    public Optional<User> getUserByEmail(String email) {
        log.info("🔍 getUserById 호출됨: {} ",email);
        return userRepository.findByEmail(email);
    }

    // UPDATE: 사용자 정보 업데이트
    public User updateUser(Long id, User newUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // DELETE: 사용자 삭제
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}