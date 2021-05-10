def solution(numbers):
    # 숫자들의 비교를 위해 str로 변환
    strNumbers = list(map(str, numbers))

    # numbers의 원소는 1,000이하 = 3자리까지 가능
    # 'n'*3을 한 후 3자리에서 자른 것을 기준으로 정렬
    # ex) 2 => '222' / 31 => '313'
    strNumbers.sort(key=lambda x: [x * 3][:3], reverse=True)

    # '001' 같은 경우는 int로 1이기 때문에 int()를 한 후 str()을 다시 해준다
    # => 문자열로 바꿔서 리턴하는 게 조건
    answer = ''.join(strNumbers)
    return str(int(answer))


solution([6, 10, 2])
solution([3, 30, 34, 5, 9])