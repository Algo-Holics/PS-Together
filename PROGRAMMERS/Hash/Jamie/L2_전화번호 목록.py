def solution(phone_book):
    # 정렬하게 되면 i+1번째가 i번째로 시작하는 경우가 접두어로 시작하는 경우가 됨
    # 따라서 for문이 2개일 필요가 없게됨
    phone_book = sorted(phone_book)
    for i in range(len(phone_book)-1):
        if phone_book[i+1].startswith(phone_book[i]):
            return False
    return True
