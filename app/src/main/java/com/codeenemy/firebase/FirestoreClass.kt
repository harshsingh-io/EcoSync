package com.codeenemy.ecosync.firebase

import android.app.Activity
import android.util.Log
import com.codeenemy.ecosync.activities.MainActivity
import com.codeenemy.ecosync.activities.SignInActivity
import com.codeenemy.ecosync.activities.SignUpActivity
import com.codeenemy.ecosync.models.User
import com.codeenemy.ecosync.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class FirestoreClass {
    private val mFireStore = FirebaseFirestore.getInstance()

    fun registerUser(activity: SignUpActivity, userInfo: User) {
        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserId())
            .set(userInfo, SetOptions.merge())
            .addOnSuccessListener {
                activity.userRegisteredSuccess()
            }.addOnFailureListener { e ->
                Log.e(activity.javaClass.simpleName, "Error writing document.", e)
            }
    }

    fun signInUser(activity: SignInActivity) {
        mFireStore.collection(Constants.USERS)
            .document(getCurrentUserId())
            .get()
            .addOnSuccessListener { document ->
                val loggedInUser = document.toObject(User::class.java)!!
                activity.signInSuccess(loggedInUser)
            }.addOnFailureListener { e ->
                activity.hideProgressDialog()

                Log.e("SignInUser", "Error occur while registering", e)
            }
    }

    //
//        fun signInUser(activity: SignInActivity) {
//            mFireStore.collection(Constants.USERS)
//                .document(getCurrentUserId())
//                .get()
//                .addOnSuccessListener { document ->
//                    Log.e(
//                        activity.javaClass.simpleName, document.toString()
//                    )
//
//                    val loggedInUser = document.toObject(User::class.java)!!
//
//                    activity.signInSuccess(loggedInUser)
//                }
//                .addOnFailureListener { e ->
//                    Log.e(
//                        activity.javaClass.simpleName,
//                        "Error while getting loggedIn user details",
//                        e
//                    )
//                }
//        }
    fun getCurrentUserId(): String {
        return FirebaseAuth.getInstance().currentUser!!.uid
    }
}