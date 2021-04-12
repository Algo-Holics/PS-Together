def solution(participant, completion):
    # dictionary를 통해 처음 참가자들의 숫자를 센다
    starts = {}
    for starter in participant:
        if starter in starts:
            value = starts[starter]
            starts[starter] = value + 1
        else:
            starts[starter] = 1

    # dictionary안에 완료한 사람의 이름이 있으면 value에서 하나씩 빼준다
    for ender in completion:
        if ender in starts:
            value = starts[ender]
            starts[ender] = value - 1

    # key:value에서 value가 0이 아닌 사람 리턴
    for k, v in starts.items():
        if v != 0:
            return k