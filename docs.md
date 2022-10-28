Scofold dev
```kotlin
//        Scaffold(
//            topBar = {
//                RallyTabRow(
//                    allScreens = rallyTabRowScreens,
//                    onTabSelected = { screen -> currentScreen = screen },
//                    currentScreen = currentScreen
//                )
//            }
//        ) { innerPadding ->
//            Box(Modifier.padding(innerPadding)) {
//                currentScreen.screen()
//            }
//        }
```

NavHost dev
```kotlin
/*NavHost(
                navController = navController,
                startDestination = Overview.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(route = Overview.route) {

//                    Overview.screen -- 第一版本
//                    OverviewScreen() -- 第二版本
                    OverviewScreen(
                        onClickSeeAllAccounts = {
                            navController.navigateSingleTopTo(Accounts.route)
                        },
                        onClickSeeAllBills = {
                            navController.navigateSingleTopTo(Bills.route)
                        },
                        onAccountClick = { accountType ->
                            navController.navigateToSingleAccount(accountType)

                        }
                    )
                    // navController 现在将获得足够的信息（例如确切目的地的路线）,可在用户点击按钮时导航到正确的目的地。
                    // 如果您查看 OverviewScreen 的实现，便会发现这些回调已设置为相应的 onClick 形参:
                }

                composable(route = Accounts.route) {
//                    Accounts.screen
                    AccountsScreen(
                        onAccountClick = { accountType ->
                            navController.navigateToSingleAccount(accountType)
                        }
                    )
                }

                composable(route = Bills.route) {
//                    Bills.screen
                    BillsScreen()
                }

                composable(
                    route = SingleAccount.routeWithArgs,
//                "${SingleAccount.route}/{${SingleAccount.accountTypeArg}}",
                    // 优化
//                    arguments = listOf(
//                        navArgument(SingleAccount.accountTypeArg){
//                            type = NavType.StringType
//                        }
//                    )
                    arguments = SingleAccount.arguments,
                    *//**
                     * adb shell am start -d "rally://single_account/Checking" -a android.intent.action.VIEW
                     *//*
                    deepLinks = SingleAccount.deepLinks

                ) { navBackStackEntry ->
                    // 您也可以为实参提供一个默认值（如果尚未提供）作为占位符，并包含这种极端情况，以提高代码的安全性。
                    val accountType: String? =
                        navBackStackEntry.arguments?.getString(SingleAccount.accountTypeArg)
                    SingleAccountScreen(accountType)
                }*/
```