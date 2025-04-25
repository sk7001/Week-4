class UserRegistration {
   public void registerUser(String username, String email, String password) {
       if (username.isEmpty() || email.isEmpty() || password.length() < 8) {
           throw new IllegalArgumentException("Invalid input");
       }
   }
}
