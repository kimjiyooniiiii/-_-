package com.example.product_manage.domain;

// 모든 계층에서 도메인 계층을 의존할 수 있으므로, 예외 클래스는 도메인 계층에 생성한다.
public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message) {
        super(message);
    }
}
