

# 시간초과
def solution_(numbers):

    tmp = map(str, numbers)
    # 모든 숫자를 붙이면 나오는 길이 확인
    length = len(''.join(tmp))

    big_numbers = []
    for i in range(len(numbers)):
        num = str(numbers[i])
        tmp = num * (length//len(num)) + num[:length%len(num)]
        big_numbers.append((tmp, i))

    big_numbers = sorted(big_numbers, reverse=True)
    answer = ''
    for number in big_numbers:
        num, idx = number
        answer += str(numbers[idx])
    # print(answer)
    return answer


solution([6, 10, 2])
solution([3, 30, 34, 5, 9])