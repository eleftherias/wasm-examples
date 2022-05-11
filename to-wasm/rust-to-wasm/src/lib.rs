#[no_mangle]
pub extern "C" fn fibonacci(n: u32) -> u32 {
    if n == 0 {
        return 0;
    }
    if n == 1 {
        return 1;
    }
    let mut prev = 0;
    let mut cur = 1;
    for _i in 2..=n {
        let sum = prev + cur;
        prev = cur;
        cur = sum;
    }
    cur
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn zeroth_fibonacci() {
        assert_eq!(0, fibonacci(0));
    }

    #[test]
    fn first_fibonacci() {
        assert_eq!(1, fibonacci(1));
    }

    #[test]
    fn nth_fibonacci() {
        assert_eq!(21, fibonacci(8));
    }
}
